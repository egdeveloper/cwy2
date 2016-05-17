package org.egdeveloper.generators;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.egdeveloper.attributes.DisplayName;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 29.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.generators
 */
public class ExcelReportGenerator implements IReportGenerator {

    @Autowired
    @Qualifier("entityInfoGetterHelper")
    private EntityInfoGetterHelper entityInfoGetterHelper;

    private Map<String, String> fonts_ = new HashMap<>();

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    @Override
    public void generateMedicalTestReport(MedicalTest test, OutputStream output) throws IOException, IllegalAccessException {
        Patient patient_ = test.getPatient();
        Workbook workbook_ = new XSSFWorkbook();
        Sheet sheet_ = workbook_.createSheet(patient_.getFullName() + " - " + test.retrieveName());

        //Patient details
        //Full name of patient
        Row row_ = sheet_.createRow(1);
        Cell cell_ = row_.createCell(0);
        cell_.setCellValue("ФИО пациента: ");
        cell_ = row_.createCell(1);
        cell_.setCellValue(patient_.getFullName());
        //Gender
        row_ = sheet_.createRow(2);
        cell_ = row_.createCell(0);
        cell_.setCellValue("Пол: ");
        cell_ = row_.createCell(1);
        cell_.setCellValue(patient_.getGender().gender2String());
        //Birthdate
        row_ = sheet_.createRow(3);
        cell_ = row_.createCell(0);
        cell_.setCellValue("Дата рождения: ");
        cell_ = row_.createCell(1);
        cell_.setCellValue(patient_.getBirthdate().toString(dateTimeFormatter));
        //Address
        row_ = sheet_.createRow(4);
        cell_ = row_.createCell(0);
        cell_.setCellValue("Место проживания: ");
        cell_ = row_.createCell(1);
        cell_.setCellValue(patient_.getCountry() + ", "
                + patient_.getPostIndex() + ", "
                + patient_.getRegion() + ", "
                + patient_.getCity() + ", "
                + patient_.getAddress());
        //Test details
        row_ = sheet_.createRow(5);
        cell_ = row_.createCell(0);
        cell_.setCellValue("Дата проведения обследования: ");
        cell_ = row_.createCell(1);
        cell_.setCellValue(test.getTestDate().toString(dateTimeFormatter));
        //Indicators details
        row_ = sheet_.createRow(7);
        cell_ = row_.createCell(0);
        cell_.setCellValue("Показатель");
        cell_ = row_.createCell(1);
        cell_.setCellValue("Значение");
        int rowIndex_ = 8;
        for(Field indicator : entityInfoGetterHelper.getAllIndicators(test.getClass())){
            row_ = sheet_.createRow(rowIndex_);
            cell_ = row_.createCell(0);
            cell_.setCellValue(indicator.getAnnotation(DisplayName.class).value());
            cell_ = row_.createCell(1);
            Object indicator_value = indicator.get(test);
            if(indicator_value == null)
                cell_.setCellValue("");
            else
                cell_.setCellValue(indicator_value.toString());
            rowIndex_++;
        }
        sheet_.autoSizeColumn(0);
        sheet_.autoSizeColumn(1);
        workbook_.write(output);
        workbook_.close();
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
