package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase(){
		String path = System.getProperty("user.dir")+"/src/main/resources/config.properties";
		try {
			prop = new Properties();
			FileInputStream fiso = new FileInputStream(path);
			prop.load(fiso);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void Initialization(){
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\owner\\Desktop\\Selenium\\Drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\owner\\Desktop\\Selenium\\Drivers\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
}
