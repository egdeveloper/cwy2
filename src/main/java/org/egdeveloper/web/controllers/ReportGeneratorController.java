package org.egdeveloper.web.controllers;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.service.data.IPatientService;
import org.egdeveloper.service.generators.IReportGeneratorService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.web.controllers
 */

@Controller
public class ReportGeneratorController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @Autowired
    @Qualifier("reportGeneratorService")
    private IReportGeneratorService reportGeneratorService;

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    // TODO: добавить поддержку кодирования имени файла в UTF-8 в зависимости от клиента
    @RequestMapping(value = "/generateTestReport/{testName}/{testID}", method = RequestMethod.GET)
    public void generateTestReport(@PathVariable("testName") String testName,
                                   @PathVariable("testID") Integer testID,
                                   @RequestParam("type") String mimeType,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception
    {
        OutputStream output = response.getOutputStream();
        try
        {
            Class testClazz = Class.forName("org.egdeveloper.data.entities." + testName.substring(0, 1).toUpperCase() + testName.substring(1));
            MedicalTest test = patientService.getMedicalTestByID(testClazz, testID);
            String reportName = reportGeneratorService.getReportGenerator(mimeType)
                    .buildName(String.format("%s - %s (%s)", test.getPatient().getFullName(),
                            ((DisplayName)testClazz.getAnnotation(DisplayName.class)).value(), test.getTestDate().toString(formatter)));
            response.setContentType(mimeType + "; charset=utf-8");
            response.setHeader("Content-Disposition", String.format("attachment; filename*=UTF-8''%s", URLEncoder.encode(reportName, "UTF-8").replace("+", "%20"))
            );
            reportGeneratorService.generateMedicalTestReport(mimeType, test, output);
        }
        finally
        {
            if(output != null)
                output.close();
        }
    }
}
