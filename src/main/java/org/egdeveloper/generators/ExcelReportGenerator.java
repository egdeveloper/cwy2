package org.egdeveloper.generators;

import org.egdeveloper.data.entities.MedicalTest;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.generators
 */
public class ExcelReportGenerator implements IReportGenerator {

    private Map<String, String> fonts_ = new HashMap<>();

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    @Override
    public void generateMedicalTestReport(MedicalTest test, OutputStream output) throws IOException, IllegalAccessException {

    }

    @Override
    public String buildName(String prefixName) {
        return prefixName + ".xlsx";
    }

    @Override
    public void setFonts(Map<String, String> fonts) {
        this.fonts_ = fonts;
    }
}
