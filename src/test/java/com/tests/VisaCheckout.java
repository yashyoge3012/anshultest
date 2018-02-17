package com.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.Cart;
import com.pages.HomePage;
import com.pages.ORRepo;
import com.utilities.XLS_Reader;

public class VisaCheckout {
	WebDriver driver;
	
	@Test
	public void visaCheckoutGuestuser()
	{
		ORRepo orRepo = new ORRepo();
		Properties pro=orRepo.getPropertyObject();
		XLS_Reader xlsreader = new XLS_Reader(System.getProperty("user.dir")+"\\Test Data\\ProductId.xlsx");
        int rowcount = xlsreader.getRowCount("Products");
        HashMap<String, String> ObjRepo = new HashMap<String, String>();
        for (int row= 1; row< rowcount ; row++)
        {
        	ObjRepo.put(xlsreader.getCellData("Products", "TestProdId", row), (xlsreader.getCellData("Products", "ProdId", row)));
        	        	
        }
        driver = Setup.getDriver();
        // iterating over HashMap
        for (Map.Entry<String,String> entry : ObjRepo.entrySet()) {

        	 // using keySet() for iteration over keys
            for (String name : ObjRepo.keySet()) 
            {
                System.out.println("key: " + name);
            }
            // using values() for iteration over keys
            for (String url : ObjRepo.values()) 
            {
                System.out.println("value: " + url);
            }
        	HomePage.searchProduct(entry.getValue(),driver);
        	Cart.cart(driver);
        	
        }
        
              
	}
	@Test
	 public static void test1 ()
     {
     	System.out.println("Test1");
     }
	 
	@Test
	 public static void test2 ()
     {
     	System.out.println("Test2");
     } 
}
