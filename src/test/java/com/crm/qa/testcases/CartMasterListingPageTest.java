/*
 * @author Devendra Singh
 * 
 */

package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartMasterListingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.TestUtil;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

@Listeners(CustomListener.class)
public class CartMasterListingPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	CartMasterListingPage Cartlistingpage;
	NewCartcreationPageTest NewCartCreationPage;

	   
	public CartMasterListingPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		Cartlistingpage = new CartMasterListingPage();
		loginPage = new LoginPage();
		NewCartCreationPage = new NewCartcreationPageTest();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
//		TestUtil.runTimeInfo("error", "login successful");
	
	}
	
//	@Test(priority=1)
//	public void verifyhomepage() throws InterruptedException{
//		homePage.verifyHomePageurl();
//	}
//	
//	@Test(priority=2)
//	public void verifyCartListingpage() throws InterruptedException{
//			homePage.verifyHomePageurl();	
//			Cartlistingpage.clickOnCartListingPage();
//			Cartlistingpage.veryfyCartLisingpage();
//			Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/cart/list");
//	}
//		
//	@Test(priority=3)
//	public void verifyUIElements() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		assert driver.findElement(By.xpath("//*[@title='Advanced Filters']")).isDisplayed() : "❌ advanc filter Not Found!";
//        assert driver.findElement(By.xpath("//*[@title='Search']")).isDisplayed() : "❌ Search Box Not Found!";
//        assert driver.findElement(By.xpath("//*[@formcontrolname='status']")).isDisplayed() : "❌ Status Dropdown Not Found!";
//        assert driver.findElement(By.xpath("//*[@title='Create Cart']")).isDisplayed() : "❌ Create Cart Button Not Found!";
//        assert driver.findElement(By.xpath(" //span[contains(text(),'Next')]")).isDisplayed() : "❌ Pagination Not Found!";
//        System.out.println("✅ All UI Elements Verified");
//        
//    }
//	
//	@Test(priority=4)
//	 public void verifySearchbtn_withCartNo() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//	     WebElement cartno = driver.findElement(By.xpath("//input[@formcontrolname='cart']"));
//	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td//child::a")).getText();
//	     cartno.sendKeys(cartno_value);
//	//     System.out.println(cartno_value);
//	     Cartlistingpage.clickon_searchbtn();
//
//	     // Get table rows (excluding headers)
//	        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//
//	        // Assert that no rows are displayed
//	        Assert.assertTrue(rows.size()> 0, " Table is not empty after search!");
//	        
//	    }
//
//	
//	@Test(priority=5)
//	 public void verifySearchbtn_withCartdes() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		 // Locate dropdown element
//        WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='cart_description']"));
//        
//        // Select "Active" from the dropdown
//        Select select = new Select(dropdown);
//        select.selectByVisibleText("Cart"); // Choose "Cart/Trolly" option
//
//        // Click the search button
//          Cartlistingpage.clickon_searchbtn();
//          Thread.sleep(1000);
//          
//        // Verify that results show only "Cart" status
//        List<WebElement> statuses = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
////        System.out.println(statuses.size());
//        Assert.assertTrue(statuses.size() > 0, "❌ No records found!");
// //       System.out.println("✅ Only 'Cart' records are displayed.");
//	  	        
//	    }
//
//
//	@Test(priority=6)
//	 public void verifySearchbtn_withStationCode() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//	     WebElement cartno = driver.findElement(By.xpath("//*[@formcontrolname='origin']"));
//	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td[3]")).getText();
//	     cartno.sendKeys(cartno_value);
//	     System.out.println(cartno_value);
//	     Cartlistingpage.clickon_searchbtn();
//
//	     // Get table rows (excluding headers)
//	        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//
//	        // Assert that no rows are displayed
//	        Assert.assertTrue(rows.size() > 0, "❌ No records found!");
//	        
//	    }
//	
//	@Test(priority=7)
//	 public void verifySearchbtn_withStatus() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		 // Locate status dropdown element
//       WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
//       Select select = new Select(dropdown);
//       select.selectByVisibleText("Active"); // Choose "Inactive/Active" option
//
//       // Click the search button
//         Cartlistingpage.clickon_searchbtn();
//         Thread.sleep(1000);
//         
//       // Verify that results show only "Active" status
//       List<WebElement> statuses = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//       System.out.println(statuses.size());
//       Assert.assertTrue(statuses.size() > 0, "❌ No records found!");
//       
//       System.out.println("✅ Only 'Active' records are displayed.");
//	  	        
//	    }
//	
//	@Test(priority=8)
//	public void testRefreshButton_withCartNo() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		//To get cart value from current table
//		String cartval = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr[1]//child::td[1]")).getText();
//		
//		// Locate and enter text in the search field
//        WebElement cartNo = driver.findElement(By.xpath("//*[@formcontrolname='cart']")); 
//        cartNo.sendKeys(cartval);
//        // Click on Search button
//        Cartlistingpage.clickon_searchbtn();
//                    
//        // Click on Refresh button
//        WebElement refreshButton = driver.findElement(By.xpath("//*[@title='Refresh']"));
//        refreshButton.click();
//        
//        // Verify the table is reset to original state
//        WebElement firstRow = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//        Assert.assertTrue(firstRow.isDisplayed(), "❌ Table did not reset!");
//        Thread.sleep(1000);
//        
//        System.out.println("✅ Refresh button works with Cart No. correctly!");
//        
//	}	
//
//	
//	@Test(priority=9)
//	public void testRefreshButton_withDes() throws InterruptedException {
//		 
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//	       WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='cart_description']"));
//           Select select = new Select(dropdown);
//           select.selectByVisibleText("Trolly"); // Choose "Cart/Trolly" option
//           Cartlistingpage.clickon_searchbtn();
//             Thread.sleep(2000);
//        	String firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr//child::td[2]")).getText();
//         	System.out.println("First raw vale is:" + firstRowdes);
//           	Assert.assertEquals(firstRowdes, "Trolly");
// 
//         	  // Step 6: Click on the Refresh button
//       		WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
//       		refreshButton_des.click();
//       		
//	}	
//	
//
//	@Test(priority=10)
//	public void testRefreshButton_withStationCode() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//	     WebElement cartno = driver.findElement(By.xpath("//*[@formcontrolname='origin']"));
//	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td[3]")).getText();
//	     cartno.sendKeys(cartno_value);
//	     System.out.println(cartno_value);
//	
//      // Click on Search button
//      Cartlistingpage.clickon_searchbtn();
//      
//      // Click on Refresh button
//      WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
//      refreshButton_des.click();
//      
//      // Verify the table is reset to original state
//      WebElement firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//      Assert.assertTrue(firstRowdes.isDisplayed(), "❌ Table did not reset!");
// 
////      System.out.println("✅ Refresh button works with Station Code correctly!");
//        
//	}	
//
//	@Test(priority=11)
//	public void testRefreshButton_withStatus() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		WebElement element = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
//		
//	 // Locate status dropdown element
//      WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
//      Select select = new Select(dropdown);
//      select.selectByVisibleText("Active"); // Choose "Inactive/Active" option   
//      // Click on Search button
//      Cartlistingpage.clickon_searchbtn();
//      
//      // Click on Refresh button
//      WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
//      refreshButton_des.click();
//      
//      // Verify the table is reset to original state
//      WebElement firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//      Assert.assertTrue(firstRowdes.isDisplayed(), "❌ Table did not reset!");
////      System.out.println("✅ Refresh button works with Status correctly!");
//        
//	}	
//
//	@Test(priority=12)
//	public void SearchButton_with_FromDate_ToDate_Morethen90days() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		
//		WebElement element = driver.findElement(By.xpath("//button[@title='Advanced Filters']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
//        
//        // Get today's date in "DD-MM-YYYY" format
//        LocalDate today = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String todayDate = today.format(formatter);
//
//     //   Thread.sleep(1000);
//        
//        // Find the date input field and enter today's date
//        WebElement fromdate = driver.findElement(By.xpath("//input[@formcontrolname='from_date']"));
//        fromdate.sendKeys("21-11-2024");
//        
//      //  Thread.sleep(1000);
//        // Find the date input field and enter today's date
//        WebElement todate = driver.findElement(By.xpath("//input[@formcontrolname='to_date']"));
//        todate.sendKeys("20-02-2025");
//        
//        Cartlistingpage.clickon_searchbtn();
//        
//        // Print confirmation
//        System.out.println("Entered Date: " + todayDate);
//        
//        // Locate all rows inside the table
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']"));
//        int rowCount = rows.size();
//       
//        // Print row count
//        System.out.println("✅ Row count is: " + rowCount);
//        
//        // Assert that table is not empty
//        Assert.assertTrue(rowCount > 1, "❌ Table did not reset!");
// 
//	}
//	
//	@Test(priority=13)
//	public void SearchButton_with_FromDate_ToDate_within90days() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		
//		WebElement element = driver.findElement(By.xpath("//button[@title='Advanced Filters']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
//        
//        // Get today's date in "DD-MM-YYYY" format
//        LocalDate today = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String todayDate = today.format(formatter);
//
//       // Thread.sleep(1000);
//        
//        // Find the date input field and enter today's date
//        WebElement fromdate = driver.findElement(By.xpath("//input[@formcontrolname='from_date']"));
//        fromdate.sendKeys("21-12-2024");
//        
//      //  Thread.sleep(1000);
//        // Find the date input field and enter today's date
//        WebElement todate = driver.findElement(By.xpath("//input[@formcontrolname='to_date']"));
//        todate.sendKeys("20-02-2025");
//        
//        Cartlistingpage.clickon_searchbtn();
//        
//        // Print confirmation
//        System.out.println("Entered Date: " + todayDate);
//        
//        // Locate all rows inside the table
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']"));
//        int rowCount = rows.size();
//       
//        // Print row count
//        System.out.println("✅ Row count is: " + rowCount);
//        
//        // Assert that table is not empty
//        Assert.assertTrue(rowCount > 0, "❌ Table did not reset!");
//        
// 
//	}	
//
//
//	@Test(priority=14)
//	public void PaginationBtn_Next() throws InterruptedException {
//		homePage.verifyHomePageurl();
//		Cartlistingpage.clickOnCartListingPage();
//		Cartlistingpage.veryfyCartLisingpage();
//		
//		WebElement element = driver.findElement(By.xpath("//button[@title='Advanced Filters']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
//         // Find the fist table value in raw one
//        String currentT1_Value = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]")).getText();
//        System.out.println("Capture Value from current Table: "+currentT1_Value);
//        
//        // Click on Next button
//        Cartlistingpage.clickon_Next_Paginationbtn();
//        
//        // Wait until table gets new rows
//        WebDriverWait wait = new WebDriverWait(driver, 10); // Timeout in seconds
//        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(
//        	    By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]"), currentT1_Value
//        	)));      
//   		
//       // Find vale after next button
//        String NextT1_Value = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]")).getText();
//       
//        // Print row count
//        System.out.println("✅ After Next Button Clik Value: " + NextT1_Value);
//              
//     // Test should fail if values are equal
//        Assert.assertNotEquals(currentT1_Value, NextT1_Value, "❌ Test failed: Pagination did not update the table data!");
//
// 
//	}	
//
	
	@Test(priority=14)
	public void CreateCartbrn_working() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		
		WebElement element = driver.findElement(By.xpath("//button[@title='Advanced Filters']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

         // Find the fist table value in raw one
        String currentT1_Value = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]")).getText();
        System.out.println("Capture Value from current Table: "+currentT1_Value);
        
        // Click on Next button
        Cartlistingpage.clickon_Next_Paginationbtn();
        
        // Wait until table gets new rows
        WebDriverWait wait = new WebDriverWait(driver, 10); // Timeout in seconds
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(
        	    By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]"), currentT1_Value
        	)));      
   		
       // Find vale after next button
        String NextT1_Value = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]/td[1]")).getText();
       
        // Print row count
        System.out.println("✅ After Next Button Clik Value: " + NextT1_Value);
              
     // Test should fail if values are equal
        Assert.assertNotEquals(currentT1_Value, NextT1_Value, "❌ Test failed: Pagination did not update the table data!");

 
	}	

	
// commit browser Closed the browser
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
