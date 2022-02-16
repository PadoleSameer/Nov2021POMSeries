package com.qa.opencart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ExcelUtil {

	private static String TEST_DATA_SHEET = "./src/test/resources/TestData/DemoCartTestData.xlsx";
	private static Workbook excelBook;
	private static Sheet sheet;
	
	public static Object [][] getTestData(String sheetName) {
		
		Object data[][] = null;
		
		try {
			FileInputStream excelFile = new FileInputStream(TEST_DATA_SHEET);
			excelBook = WorkbookFactory.create(excelFile);
			sheet = excelBook.getSheet(sheetName);
			
//			System.out.println("Row Count"+sheet.getLastRowNum());
//			System.out.println("Column Count"+sheet.getRow(0).getLastCellNum());
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum();i++ ) {
				for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
				{
					
					//System.out.println(sheet.getRow(i).getCell(j)+" ");
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
