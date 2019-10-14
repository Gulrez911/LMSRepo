package com.assessment.web.controllers;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.assessment.data.Question;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * 
 * @author www.codejava.net
 *
 */
public class ExcelBuilder extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<Question> listQ = (List<Question>) model.get("listquestion");

		System.out.println("build excell" + listQ);
		// create a new Excel sheet
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("QuestionFileDownload");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
//		style.setFillForegroundColor(HSSFColor.BLUE.index);
//		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("Question Text");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Choice1");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Choice2");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("Choice3");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Choice4");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Choice5");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Choice6");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("RightChoices");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Qualifier1");
		header.getCell(8).setCellStyle(style);

		header.createCell(9).setCellValue("Qualifier2");
		header.getCell(9).setCellStyle(style);

		header.createCell(10).setCellValue("Qualifier3");
		header.getCell(10).setCellStyle(style);

		header.createCell(11).setCellValue("Qualifier4");
		header.getCell(11).setCellStyle(style);

		header.createCell(12).setCellValue("Qualifier5");
		header.getCell(12).setCellStyle(style);

		header.createCell(13).setCellValue("Difficulty Level");
		header.getCell(13).setCellStyle(style);

		header.createCell(14).setCellValue("Instruction If Any");
		header.getCell(14).setCellStyle(style);

		header.createCell(15).setCellValue("CompanyId");
		header.getCell(15).setCellStyle(style);
		// create data rows
		int rowCount = 1;

		for (Question ques : listQ) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(ques.getQuestionText());
			aRow.createCell(1).setCellValue(ques.getChoice1());
			aRow.createCell(2).setCellValue(ques.getChoice2());
			aRow.createCell(3).setCellValue(ques.getChoice3());
			aRow.createCell(4).setCellValue(ques.getChoice4());
			aRow.createCell(5).setCellValue(ques.getChoice5());
			aRow.createCell(6).setCellValue(ques.getChoice6());
			aRow.createCell(7).setCellValue(ques.getRightChoices());
			aRow.createCell(8).setCellValue(ques.getQualifier1());
			aRow.createCell(9).setCellValue(ques.getQualifier2());
			aRow.createCell(10).setCellValue(ques.getQualifier3());
			aRow.createCell(11).setCellValue(ques.getQualifier4());
			aRow.createCell(12).setCellValue(ques.getQualifier5());
			aRow.createCell(13).setCellValue(ques.getDifficultyLevel().getLevel());
			aRow.createCell(14).setCellValue(ques.getInstructionsIfAny());
			aRow.createCell(15).setCellValue(ques.getCompanyId());
		}
	}

}
