package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {

	public static void mysearchedproduct(WebDriver driver)
	{
		ORRepo orRepo = new ORRepo();
		Properties pro=orRepo.getPropertyObject();
		driver.findElement(By.xpath(pro.getProperty("Shop"))).click();
		driver.findElement(By.xpath(pro.getProperty("hgoods"))).click();
	}
}
