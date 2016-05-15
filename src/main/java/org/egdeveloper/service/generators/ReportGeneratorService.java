package org.egdeveloper.service.generators;

import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.generators.IReportGenerator;
import org.springframework.stereotype.Service;

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

    private Map<String, IReportGenerator> reportGenerators_ = new HashMap<>();
    private Map<String, String> fonts_ = new HashMap<>();

    @Override
    public void generateMedicalTestReport(String mimeType, MedicalTest test, OutputStream output) throws Exception {
        reportGenerators_.get(mimeType).generateMedicalTestReport(test, output);
    }

    @Override
    public IReportGenerator getReportGenerator(String mimeType) {
        return reportGenerators_.get(mimeType);
    }

    @Override
    public void setFonts(Map<String, String> fonts) {
        this.fonts_ = fonts;
    }

    public Map<String, IReportGenerator> getReportGenerators() {
        return reportGenerators_;
    }

    public void setReportGenerators(Map<String, IReportGenerator> reportGenerators) {
        this.reportGenerators_ = reportGenerators;
    }
}
