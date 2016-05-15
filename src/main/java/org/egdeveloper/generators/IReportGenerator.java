package org.egdeveloper.generators;

import org.egdeveloper.data.entities.MedicalTest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.generators
 */
public interface IReportGenerator {
    void generateMedicalTestReport(MedicalTest test, OutputStream output) throws Exception;
    String buildName(String prefixName);
    void setFonts(Map<String, String> fonts);
}
