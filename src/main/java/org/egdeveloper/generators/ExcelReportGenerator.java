package org.egdeveloper.generators;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.Indicator;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.generators
 */
public class ExcelReportGenerator implements IReportGenerator {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    @Override
    public void generateMedicalTestReport(MedicalTest test, OutputStream output) throws IOException, IllegalAccessException {

    }
}
