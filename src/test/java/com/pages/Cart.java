package com.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class Cart {

	public static void cart(WebDriver driver)
	{
		ORRepo orRepo = new ORRepo();
		Properties pro=orRepo.getPropertyObject();
		//driver.findElement(By.cssSelector("button.add-to-cart")).click();
	//	driver.findElement(By.xpath("./*[@id='prodRCol']/div[1]/h2")).click();
		driver.findElement(By.xpath(pro.getProperty("AddCart"))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text() = 'Checkout']")).click();
		//Entering data in the Billing Address
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='billingAddress.address.firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.address.firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='billingAddress.address.lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.address.lastName']")).sendKeys("Cena");
		driver.findElement(By.xpath("//input[@id='billingAddress.address.address1']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.address.address1']")).sendKeys("71 Pilgrim Avenue");
		driver.findElement(By.xpath("//input[@id='billingAddress.address.address2']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.address.address2']")).sendKeys("Chevy Chase");
		driver.findElement(By.xpath("//input[@id='billingAddress.address.city']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.address.city']")).sendKeys("TUCSON");
		driver.findElement(By.xpath("//select[@id='billingAddress.address.state']")).clear();
		driver.findElement(By.xpath("//select[@id='billingAddress.address.state']")).sendKeys("AZ");
		//Postal Code added below
		driver.findElement(By.xpath("//fieldset[@id='billingAddress']/div[7]/div[2]/input")).clear();
		driver.findElement(By.xpath("//fieldset[@id='billingAddress']/div[7]/div[2]/input")).sendKeys("85705");
		driver.findElement(By.xpath("//input[@id='billingAddress.phone']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.phone']")).sendKeys("895-895-8956");
		driver.findElement(By.xpath("//input[@id='billingAddress.emailAddress']")).clear();
		driver.findElement(By.xpath("//input[@id='billingAddress.emailAddress']")).sendKeys("yoge.anshul@gmail.com");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(pro.getProperty("ReturnToCart"))).click();
		//driver.quit();
		
	}
	
	@AfterSuite(alwaysRun = true)
	
	public void tearDown(WebDriver driver)
	{
		driver.quit();
	}
}
