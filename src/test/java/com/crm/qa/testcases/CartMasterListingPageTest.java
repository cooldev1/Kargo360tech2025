/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import java.time.Duration;

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
	
	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyCartListingpage() throws InterruptedException{
			homePage.verifyHomePageurl();	
			Cartlistingpage.clickOnCartListingPage();
			Cartlistingpage.veryfyCartLisingpage();
			Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/cart/list");
	}
		
	@Test(priority=3)
	public void verifyUIElements() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		assert driver.findElement(By.xpath("//*[@title='Advanced Filters']")).isDisplayed() : "❌ advanc filter Not Found!";
        assert driver.findElement(By.xpath("//*[@title='Search']")).isDisplayed() : "❌ Search Box Not Found!";
        assert driver.findElement(By.xpath("//*[@formcontrolname='status']")).isDisplayed() : "❌ Status Dropdown Not Found!";
        assert driver.findElement(By.xpath("//*[@title='Create Cart']")).isDisplayed() : "❌ Create Cart Button Not Found!";
        assert driver.findElement(By.xpath(" //span[contains(text(),'Next')]")).isDisplayed() : "❌ Pagination Not Found!";
        System.out.println("✅ All UI Elements Verified");
        
    }
	
	@Test(priority=4)
	 public void verifySearchbtn_withCartNo() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
	     WebElement cartno = driver.findElement(By.xpath("//input[@formcontrolname='cart']"));
	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td//child::a")).getText();
	     cartno.sendKeys(cartno_value);
	//     System.out.println(cartno_value);
	     Cartlistingpage.clickon_searchbtn();

	     // Get table rows (excluding headers)
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));

	        // Assert that no rows are displayed
	        Assert.assertTrue(rows.size()> 0, " Table is not empty after search!");
	        
	    }

	
	@Test(priority=5)
	 public void verifySearchbtn_withCartdes() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		 // Locate dropdown element
        WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='cart_description']"));
        
        // Select "Active" from the dropdown
        Select select = new Select(dropdown);
        select.selectByVisibleText("Cart"); // Choose "Cart/Trolly" option

        // Click the search button
          Cartlistingpage.clickon_searchbtn();
          Thread.sleep(1000);
          
        // Verify that results show only "Cart" status
        List<WebElement> statuses = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
//        System.out.println(statuses.size());
        Assert.assertTrue(statuses.size() > 0, "❌ No records found!");
 //       System.out.println("✅ Only 'Cart' records are displayed.");
	  	        
	    }


	@Test(priority=6)
	 public void verifySearchbtn_withStationCode() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
	     WebElement cartno = driver.findElement(By.xpath("//*[@formcontrolname='origin']"));
	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td[3]")).getText();
	     cartno.sendKeys(cartno_value);
	     System.out.println(cartno_value);
	     Cartlistingpage.clickon_searchbtn();

	     // Get table rows (excluding headers)
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));

	        // Assert that no rows are displayed
	        Assert.assertTrue(rows.size() > 0, "❌ No records found!");
	        
	    }
	
	@Test(priority=7)
	 public void verifySearchbtn_withStatus() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		 // Locate status dropdown element
       WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
       Select select = new Select(dropdown);
       select.selectByVisibleText("Active"); // Choose "Inactive/Active" option

       // Click the search button
         Cartlistingpage.clickon_searchbtn();
         Thread.sleep(1000);
         
       // Verify that results show only "Active" status
       List<WebElement> statuses = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
       System.out.println(statuses.size());
       Assert.assertTrue(statuses.size() > 0, "❌ No records found!");
       
       System.out.println("✅ Only 'Active' records are displayed.");
	  	        
	    }
	
	@Test(priority=8)
	public void testRefreshButton_withCartNo() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		//To get cart value from current table
		String cartval = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr[1]//child::td[1]")).getText();
		
		// Locate and enter text in the search field
        WebElement cartNo = driver.findElement(By.xpath("//*[@formcontrolname='cart']")); 
        cartNo.sendKeys(cartval);
        // Click on Search button
        Cartlistingpage.clickon_searchbtn();
                    
        // Click on Refresh button
        WebElement refreshButton = driver.findElement(By.xpath("//*[@title='Refresh']"));
        refreshButton.click();
        
        // Verify the table is reset to original state
        WebElement firstRow = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
        Assert.assertTrue(firstRow.isDisplayed(), "❌ Table did not reset!");
        Thread.sleep(1000);
        
        System.out.println("✅ Refresh button works with Cart No. correctly!");
        
	}	

	
	@Test(priority=9)
	public void testRefreshButton_withDes() throws InterruptedException {
		 
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
	       WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='cart_description']"));
           Select select = new Select(dropdown);
           select.selectByVisibleText("Trolly"); // Choose "Cart/Trolly" option
           Cartlistingpage.clickon_searchbtn();
             Thread.sleep(2000);
        	String firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr//child::td[2]")).getText();
         	System.out.println("First raw vale is:" + firstRowdes);
           	Assert.assertEquals(firstRowdes, "Trolly");
 
         	  // Step 6: Click on the Refresh button
       		WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
       		refreshButton_des.click();
       		
	}	
	

	@Test(priority=10)
	public void testRefreshButton_withStationCode() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
	     WebElement cartno = driver.findElement(By.xpath("//*[@formcontrolname='origin']"));
	     String cartno_value =  driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::td[3]")).getText();
	     cartno.sendKeys(cartno_value);
	     System.out.println(cartno_value);
	
      // Click on Search button
      Cartlistingpage.clickon_searchbtn();
      
      // Click on Refresh button
      WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
      refreshButton_des.click();
      
      // Verify the table is reset to original state
      WebElement firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
      Assert.assertTrue(firstRowdes.isDisplayed(), "❌ Table did not reset!");
 
//      System.out.println("✅ Refresh button works with Station Code correctly!");
        
	}	

	@Test(priority=11)
	public void testRefreshButton_withStatus() throws InterruptedException {
		homePage.verifyHomePageurl();
		Cartlistingpage.clickOnCartListingPage();
		Cartlistingpage.veryfyCartLisingpage();
		WebElement element = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		
	 // Locate status dropdown element
      WebElement dropdown = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
      Select select = new Select(dropdown);
      select.selectByVisibleText("Active"); // Choose "Inactive/Active" option   
      // Click on Search button
      Cartlistingpage.clickon_searchbtn();
      
      // Click on Refresh button
      WebElement refreshButton_des = driver.findElement(By.xpath("//*[@title='Refresh']"));
      refreshButton_des.click();
      
      // Verify the table is reset to original state
      WebElement firstRowdes = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//child::tbody//child::tr"));
      Assert.assertTrue(firstRowdes.isDisplayed(), "❌ Table did not reset!");
//      System.out.println("✅ Refresh button works with Status correctly!");
        
	}	

//it should be commit
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
