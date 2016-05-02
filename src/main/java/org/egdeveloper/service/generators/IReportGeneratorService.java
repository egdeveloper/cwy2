package org.egdeveloper.service.generators;

import org.egdeveloper.data.entities.MedicalTest;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 28.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.service
 */
public interface IReportGeneratorService {
    void generateMedicalTestReport(String mimeType, MedicalTest test, OutputStream output) throws IOException, IllegalAccessException;
}
