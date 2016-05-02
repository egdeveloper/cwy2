package org.egdeveloper.generators;

import org.apache.poi.xwpf.usermodel.*;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.Indicator;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.helpers.EntityInfoGetterHelper;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.generators
 */
public class WordReportGenerator implements IReportGenerator {

    @Autowired
    @Qualifier("entityInfoGetterHelper")
    private EntityInfoGetterHelper entityInfoGetterHelper;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    @Override
    public void generateMedicalTestReport(MedicalTest test, OutputStream output) throws IllegalAccessException, IOException {

        List<Field> indicators = entityInfoGetterHelper.getAllIndicators(test.getClass());

        Patient patient = test.getPatient();
        XWPFDocument document = new XWPFDocument();

        //header
        XWPFParagraph header_paragraph = document.createParagraph();
        header_paragraph.setSpacingAfter(2);
        XWPFRun header_content = header_paragraph.createRun();
        header_content.setBold(true);
        header_content.setFontFamily("Times New Roman");
        header_content.setFontSize(18);
        header_content.setText(test.retrieveName());
        //header: end

        //main information
        XWPFTable mainInfo_table = document.createTable(5, 2);
        mainInfo_table.getRow(0).getCell(0).setText("ФИО пациента:");
        mainInfo_table.getRow(0).getCell(1).setText(patient.getFullName());
        mainInfo_table.getRow(1).getCell(0).setText("Пол:");
        mainInfo_table.getRow(1).getCell(1).setText(patient.getGender().gender2String());
        mainInfo_table.getRow(2).getCell(0).setText("Дата рождения:");
        mainInfo_table.getRow(2).getCell(1).setText(patient.getBirthdate().toString(dateTimeFormatter));
        mainInfo_table.getRow(3).getCell(0).setText("Место проживания:");
        mainInfo_table.getRow(3).getCell(1).setText(patient.getCountry() + ", "
                + patient.getPostIndex() + ", "
                + patient.getRegion() + ", "
                + patient.getCity() + ", "
                + patient.getAddress());
        mainInfo_table.getRow(4).getCell(0).setText("Дата проведения обследования:");
        mainInfo_table.getRow(4).getCell(1).setText(test.getTestDate().toString(dateTimeFormatter));
        //main information: end

        document.createParagraph().setSpacingAfter(2);
        //indicators
        XWPFTable indicators_table = document.createTable(indicators.size() + 1, 2);
        indicators_table.getRow(0).getCell(0).setText("Показатель");
        indicators_table.getRow(0).getCell(1).setText("Значение");
        int row_index = 1;
        for(Field indicator : indicators){
            indicators_table.getRow(row_index).getCell(0).setText(indicator.getAnnotation(DisplayName.class).value());
            Object indicator_value = indicator.get(test);
            if(indicator_value == null)
                indicators_table.getRow(row_index).getCell(1).setText("");
            else
                indicators_table.getRow(row_index).getCell(1).setText(indicator_value.toString());
            row_index++;
        }
        //indicators: end
        document.write(output);
        output.flush();
    }
}
