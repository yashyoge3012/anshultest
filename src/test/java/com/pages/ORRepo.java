package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ORRepo {
	
	WebDriver driver;
	Properties pro; 
	public  ORRepo(){
		
	}
	public  ORRepo(WebDriver driver){
		this.driver = driver;
	}
	
	public void TestOR() throws IOException{
		 
		// Specify the file location I used . operation here because
		//we have object repository inside project directory only
		//File src=new File("E:\\Selenium\\Testing123\\src\\test\\java\\ObjectRepo.properties");
		//File src=new File (System.getProperty("user.dir")+"\\Test Data"+"\\"+"ProductId.xlsx";
		File src=new File (System.getProperty("user.dir")+"\\src"+"\\main"+"\\java"+"\\"+"ObjectRepo.properties");
		 
		// Create  FileInputStream object
		FileInputStream fis=new FileInputStream(src);
		pro =new Properties();
		// Load file so we can use into our script
		pro.load(fis);
		
		}
	public Properties getPropertyObject() {
		if(null == pro){
			try {
				TestOR();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pro;
	}
}
