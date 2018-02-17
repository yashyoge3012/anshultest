package com.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.ORRepo;

public class Setup {
	
	
	public static WebDriver getInstance(){
		return driver;
	}
	
	
	static WebDriver driver = null;
	
	public static WebDriver getDriver(){
		if(driver == null){
			driver =  setup();
		}
		
			return driver;
	}
	
	@Before
	public static WebDriver setup(){
		   ORRepo orRepo = new ORRepo();
		   Properties pro=orRepo.getPropertyObject();
	       //System.setProperty("webdriver.firefox.marionette","C:\\Selenium\\geckodriver\\geckodriver.exe");
	        driver= new FirefoxDriver();
	        driver.get("http://www.acehardware.com/home/index.jsp");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.xpath(pro.getProperty("InitialPopClose"))).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
			
			}
}
