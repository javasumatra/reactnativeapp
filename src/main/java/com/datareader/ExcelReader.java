package com.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] ReadMyData(String testFile, String sheetName) throws IOException{
		FileInputStream excelFile = new FileInputStream(testFile);
		XSSFWorkbook wb = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}	
		}
		return data;
	}
	

}
