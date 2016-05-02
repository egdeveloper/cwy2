package org.egdeveloper.service.generators;

import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.generators.IReportGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 28.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.service
 */

@Service("reportGeneratorService")
public class ReportGeneratorService implements IReportGeneratorService {

    private Map<String, IReportGenerator> reportGenerators = new HashMap<>();

    @Override
    public void generateMedicalTestReport(String mimeType, MedicalTest test, OutputStream output) throws IOException, IllegalAccessException {
        reportGenerators.get(mimeType).generateMedicalTestReport(test, output);
    }

    public Map<String, IReportGenerator> getReportGenerators() {
        return reportGenerators;
    }

    public void setReportGenerators(Map<String, IReportGenerator> reportGenerators) {
        this.reportGenerators = reportGenerators;
    }
}
