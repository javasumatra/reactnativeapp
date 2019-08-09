package com.qa.tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datareader.ExcelReader;
import com.qa.base.TestBase;
public class ExcelReadTest extends TestBase{
	
	ExcelReadTest(){
		super();
	}
	
	@BeforeMethod
	public static void setup(){
		Initialization();
		driver.get("http://www.google.com");

	}
	
	@DataProvider
	public Object[][] ReadData() throws IOException{
		String File = "C:\\Users\\owner\\Desktop\\Selenium\\TestData.xlsx";
		String sheet = "Sheet2";
		Object[][] data = ExcelReader.ReadMyData(File, sheet);
		return data;
	}
	
	@Test(dataProvider="ReadData")
	public static void LoginWithMultipleUsers(String ui, String pw){
		System.out.println(ui);
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(ui);
		
		
	}
	
}
