package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenTest {
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\data.xlsx";

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	

		FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);

		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("CrateUserUser");

		System.out.println("last row noumber : " + sheet.getLastRowNum());

		System.out.println("last column number : " + sheet.getRow(0).getLastCellNum());
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				
				 System.out.println(sheet.getRow(i + 1).getCell(k).toString());
			}
		}
		
//		Sheet sheet2 = book.getSheet("CrateUserUser");
//
//		System.out.println("last row noumber : " + sheet2.getLastRowNum());
//
//		System.out.println("last column number : " + sheet2.getRow(0).getLastCellNum());

	}
}
