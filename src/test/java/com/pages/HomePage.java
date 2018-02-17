package com.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public  HomePage(WebDriver driver){
		this.driver = driver;
	}
	public static void searchProduct(String prod, WebDriver driver )
	{
		ORRepo orRepo = new ORRepo();
		Properties pro=orRepo.getPropertyObject();
		driver.findElement(By.xpath(pro.getProperty("SearchHeader"))).click();
		driver.findElement(By.xpath(pro.getProperty("SearchHeader"))).sendKeys(prod);
		driver.findElement(By.xpath(pro.getProperty("Search_Go"))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
}
