package com.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class TestBrowser extends TestBase{
	TestBrowser(){
		super();
	}
	@BeforeTest
	public void setup(){
		Initialization();
	}
	
	@Test
	public void OpenBrowser(){
		
		driver.get("http://www.google.com");
		
	}
	@Test
	public void CheckTitle(){
		
		driver.get("http://www.google.com");
		System.out.println("I want to check title here!");
		
	}
}
