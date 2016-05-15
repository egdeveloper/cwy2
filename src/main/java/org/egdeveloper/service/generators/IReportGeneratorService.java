package org.egdeveloper.service.generators;

import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.generators.IReportGenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 28.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.service
 */
public interface IReportGeneratorService {
    void generateMedicalTestReport(String mimeType, MedicalTest test, OutputStream output) throws IOException, IllegalAccessException, Exception;
    IReportGenerator getReportGenerator(String mimeType);
    void setFonts(Map<String, String> fonts);
}
