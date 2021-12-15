package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReUsableMethods {

//	public static String TESTDATA_SHEET_PATH = "./src/test/resources/com/testdata/logintestdata.xlsx";

//	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\data.xlsx";
	
	public static String filePath = "E:\\AutomationWorkspace\\data.xlsx"; // test file path to read test data for user creation.

	static Workbook book; // declaring workbook
	static Sheet sheet;// declaring sheet
	static JavascriptExecutor js;

	public void selectListItem(WebElement role, String roletype) {
		Select se = new Select(role);
		se.selectByVisibleText(roletype);
	}

	
	public static Object[][] readData() throws IOException {

		FileInputStream fis = new FileInputStream(filePath);

		Workbook book = WorkbookFactory.create(fis);

		sheet = book.getSheet("CrateUserUser"); // we can pass sheet name dynamically in the method parameters

		System.out.println("last row noumber (row count) : " + sheet.getLastRowNum());

		System.out.println("last column number ( Column Count ) : " + sheet.getRow(0).getLastCellNum());

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;

	}
	
	
	
	public static Object[][] test2() throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("CrateUserUser");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
