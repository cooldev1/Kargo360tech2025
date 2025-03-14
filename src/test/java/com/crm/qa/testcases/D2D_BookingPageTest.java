package com.crm.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartMasterListingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CustomListener;
import com.crm.qa.util.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Listeners(CustomListener.class)
public class D2D_BookingPageTest  extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestBase TestBase;
	com.crm.qa.pages.D2D_Booking_Page D2D_Booking_Page;
		
	public D2D_BookingPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		D2D_Booking_Page = new com.crm.qa.pages.D2D_Booking_Page();
	}

	@Test(priority=1)
	public void verifyhomepage() throws InterruptedException{
		homePage.verifyHomePageurl();
	}
	
	@Test(priority=2)
	public void verifyD2D_Booking_gpage() throws InterruptedException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
	}
	
	
	@Test(priority=3)
	public void D2D_Prepaid_Warehouse_To_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(0);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		
					  
					  
					  
		
            }
        }
	
	@Test(priority=4)
	public void D2DBooking_Prepaid_Gen_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(1);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      				
            }
        }
	
//	@Test(priority=5)
//	public void D2DBooking_Po_Mail_S_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(2);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
//	//select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      							  
//		
//            }
//        }
//
	@Test(priority=6)
	public void D2DBooking_Walking_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(3);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  Thread.sleep(2000);
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      							  
//To Collect Button
			  
			    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			    	  Thread.sleep(2000);
			    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			    	  Thread.sleep(2000);
			    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			    	  Thread.sleep(3000);
			    	//To Capture the Collect Msg PopUp
			            
				     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
				         System.out.println("Whai is error msg:- "+Collectmsg );
				    
				        
				         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
				         String newTextmsg = partc[1]; // Access the part after "is"
				         
//				         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//				         String newText1 = parts1[1]; // Access the part after "is"
				         System.out.println(newTextmsg);
				          
				 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			    	  
			    	  
			    	  
            }
        }
	
	@Test(priority=7)
	public void D2D_Prepaid_Single_leg_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(4);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					select2.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem2);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		
					  	  
		
            }
        }
			    	  
//	@Test(priority=8)
//	public void D2D_Prepaid_Single_leg_PoMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(5);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////Last Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					select2.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem2);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		
//					  	  
//		
//            }
//        }
//            
	@Test(priority=9)
	public void D2D_Prepaid_Single_leg_Walking_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(6);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					select2.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem2);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  
		
        
//To Collect Button
	  
	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
	    	  Thread.sleep(2000);
	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
	    	  Thread.sleep(2000);
	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
	    	  Thread.sleep(3000);
	    	//To Capture the Collect Msg PopUp
	            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+Collectmsg );
		    
		        
		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
		         String newTextmsg = partc[1]; // Access the part after "is"
		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newTextmsg);
		          
		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);


        }
    }
	
	@Test(priority=10)
	public void D2D_Prepaid_Double_leg_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(7);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------First Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-----------To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  		
        

        }
    }

//	@Test(priority=11)
//	public void D2D_Prepaid_Double_leg_POMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(8);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------First Flight Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-----------To Select second leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
////Last Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
//					select3.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d3 = 0;
//					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate3 = new Date();
//						String Dateofsystem3 = formatdate3.format(SystemDate3);	
//						//System.out.println(Dateofsystem3);
//						String arr3[]=Dateofsystem3.split("/");
//						String days3 = arr3[0];		
//						int s3 = (int) Integer.parseInt(days3);
//						String day3=String.valueOf(s3+d3); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
//					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
//					  js3.executeScript("arguments[0].click()", datepicker3);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele3:alldaate3) 
//					  {
//						  String dt3 = ele3.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt3.equals(day3))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele3.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//					  	  		
//        
//
//        }
//    }
	@Test(priority=12)
	public void D2D_Prepaid_Double_leg_WLK_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(9);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------First Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-----------To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

//To Collect Button
			      	  
			      	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			      	    	  Thread.sleep(3000);
			      	    	//To Capture the Collect Msg PopUp
			      	            
			      		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
			      		         System.out.println("Whai is error msg:- "+Collectmsg );
			      		    
			      		        
			      		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
			      		         String newTextmsg = partc[1]; // Access the part after "is"
			      		         
//			      		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//			      		         String newText1 = parts1[1]; // Access the part after "is"
			      		         System.out.println(newTextmsg);
			      		          
			      		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			      					  	  		
        

        }
    }
	@Test(priority=13)
	public void D2D_Prepaid_Double_leg_Wh2wh_SingleFlight_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(10);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Fisrt Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Truck Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Second Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-------To Select Fist leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Destination First Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Destination Second Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
					select4.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d4 = 0;
					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate4 = new Date();
						String Dateofsystem4 = formatdate4.format(SystemDate4);	
						//System.out.println(Dateofsystem4);
						String arr4[]=Dateofsystem4.split("/");
						String days4 = arr4[0];		
						int s4 = (int) Integer.parseInt(days4);
						String day4=String.valueOf(s4+d4); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
					  js4.executeScript("arguments[0].click()", datepicker4);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele4:alldaate4) 
					  {
						  String dt4 = ele4.getText();
						//  System.out.println(dt1);
						  

						   if(dt4.equals(day4))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele4.click();
							  break;
						  }
						 
					  }
					  
          //Select Truck for second leg Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

        }
    }
//	@Test(priority=14)
//	public void D2D_Prepaid_Double_leg_Wh2wh_SingleFlight_POMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(11);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Fisrt Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Second Truck Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Second Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-------To Select Fist leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
////Destination First Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
//					select3.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination  via Warehouse
//				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d3 = 0;
//					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate3 = new Date();
//						String Dateofsystem3 = formatdate3.format(SystemDate3);	
//						//System.out.println(Dateofsystem3);
//						String arr3[]=Dateofsystem3.split("/");
//						String days3 = arr3[0];		
//						int s3 = (int) Integer.parseInt(days3);
//						String day3=String.valueOf(s3+d3); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
//					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
//					  js3.executeScript("arguments[0].click()", datepicker3);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele3:alldaate3) 
//					  {
//						  String dt3 = ele3.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt3.equals(day3))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele3.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////Destination Second Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
//					select4.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination  via Warehouse
//				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d4 = 0;
//					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate4 = new Date();
//						String Dateofsystem4 = formatdate4.format(SystemDate4);	
//						//System.out.println(Dateofsystem4);
//						String arr4[]=Dateofsystem4.split("/");
//						String days4 = arr4[0];		
//						int s4 = (int) Integer.parseInt(days4);
//						String day4=String.valueOf(s4+d4); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
//					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
//					  js4.executeScript("arguments[0].click()", datepicker4);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele4:alldaate4) 
//					  {
//						  String dt4 = ele4.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt4.equals(day4))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele4.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Truck for second leg Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);		      					  	  		
 //       }
 //   }
	@Test(priority=15)
	public void D2D_Prepaid_Double_leg_Wh2wh_SingleFlight_Walking_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(12);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Fisrt Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Truck Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Second Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-------To Select Fist leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Destination First Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Destination Second Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
					select4.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d4 = 0;
					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate4 = new Date();
						String Dateofsystem4 = formatdate4.format(SystemDate4);	
						//System.out.println(Dateofsystem4);
						String arr4[]=Dateofsystem4.split("/");
						String days4 = arr4[0];		
						int s4 = (int) Integer.parseInt(days4);
						String day4=String.valueOf(s4+d4); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
					  js4.executeScript("arguments[0].click()", datepicker4);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele4:alldaate4) 
					  {
						  String dt4 = ele4.getText();
						//  System.out.println(dt1);
						  

						   if(dt4.equals(day4))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele4.click();
							  break;
						  }
						 
					  }
					  
          //Select Truck for second leg Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

//To Collect Button
			      	  
			      	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			      	    	  Thread.sleep(3000);
			      	    	//To Capture the Collect Msg PopUp
			      	            
			      		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
			      		         System.out.println("Whai is error msg:- "+Collectmsg );
			      		    
			      		        
			      		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
			      		         String newTextmsg = partc[1]; // Access the part after "is"
			      		         
//			      		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//			      		         String newText1 = parts1[1]; // Access the part after "is"
			      		         System.out.println(newTextmsg);
			      		          
			      		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			      					  	  		
        }
    }
	@Test(priority=16)
	public void D2D_Postpaid_Warehouse_To_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(13);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);					  
		
            }
        }
	
	@Test(priority=17)
	public void D2DBooking_Postpaid_Gen_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(14);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      				
            }
        }
	
//	@Test(priority=18)
//	public void D2DBooking_PostPaid_Po_Mail_S_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(15);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(2000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
//	//select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
// 	//Select Route Destination
//				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//   //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
////Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					System.out.println("Testing");
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      							  
//		
//            }
//        }

	@Test(priority=19)
	public void D2DBooking_Postpaid_Walking_Warehouse_to_Warehouse_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(16);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(2000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
	//select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
 	//Select Route Destination
				//  String des  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
   //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
//Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					System.out.println("Testing");
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  Thread.sleep(2000);
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      							  
//To Collect Button
			  
			    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			    	  Thread.sleep(2000);
			    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			    	  Thread.sleep(2000);
			    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			    	  Thread.sleep(3000);
			    	//To Capture the Collect Msg PopUp
			            
				     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
				         System.out.println("Whai is error msg:- "+Collectmsg );
				    
				        
				         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
				         String newTextmsg = partc[1]; // Access the part after "is"
				         
//				         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//				         String newText1 = parts1[1]; // Access the part after "is"
				         System.out.println(newTextmsg);
				          
				 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			    	  
			    	  
			    	  
            }
        }
	
	@Test(priority=20)
	public void D2DBooking_PostPaid_Single_leg_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(17);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					select2.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem2);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		
					  	  
		
            }
        }
			    	  
//	@Test(priority=21)
//	public void D2D_Postpaid_Single_leg_PoMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(18);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////Last Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					select2.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem2);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		
//					  	  
//		
//            }
//        }
//            
	@Test(priority=22)
	public void D2D_Postpaid_Single_leg_Walking_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(19);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					select2.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem2);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  
		
        
//To Collect Button
	  
	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
	    	  Thread.sleep(2000);
	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
	    	  Thread.sleep(2000);
	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
	    	  Thread.sleep(3000);
	    	//To Capture the Collect Msg PopUp
	            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+Collectmsg );
		    
		        
		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
		         String newTextmsg = partc[1]; // Access the part after "is"
		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newTextmsg);
		          
		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);


        }
    }
	
	@Test(priority=23)
	public void D2D_Postpaid_Double_leg_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(20);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------First Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-----------To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);
					  	  		
        

        }
    }

//	@Test(priority=24)
//	public void D2D_Postpaid_Double_leg_POMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(21);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------First Flight Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-----------To Select second leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
////Last Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
//					select3.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d3 = 0;
//					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate3 = new Date();
//						String Dateofsystem3 = formatdate3.format(SystemDate3);	
//						//System.out.println(Dateofsystem3);
//						String arr3[]=Dateofsystem3.split("/");
//						String days3 = arr3[0];		
//						int s3 = (int) Integer.parseInt(days3);
//						String day3=String.valueOf(s3+d3); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
//					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
//					  js3.executeScript("arguments[0].click()", datepicker3);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele3:alldaate3) 
//					  {
//						  String dt3 = ele3.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt3.equals(day3))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele3.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//					  	  		
//        
//
//        }
//    }
	@Test(priority=25)
	public void D2D_Postpaid_Double_leg_WLK_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(22);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------First Flight Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String via  =  sheet.getRow(i).getCell(16).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-----------To Select second leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem2);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Last Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  //String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

//To Collect Button
			      	  
			      	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			      	    	  Thread.sleep(3000);
			      	    	//To Capture the Collect Msg PopUp
			      	            
			      		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
			      		         System.out.println("Whai is error msg:- "+Collectmsg );
			      		    
			      		        
			      		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
			      		         String newTextmsg = partc[1]; // Access the part after "is"
			      		         
//			      		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//			      		         String newText1 = parts1[1]; // Access the part after "is"
			      		         System.out.println(newTextmsg);
			      		          
			      		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			      					  	  		
        

        }
    }
	@Test(priority=26)
	public void D2D_Postpaid_Double_leg_Wh2wh_SingleFlight_Gen_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(23);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Fisrt Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Truck Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Second Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-------To Select Fist leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Destination First Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Destination Second Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
					select4.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d4 = 0;
					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate4 = new Date();
						String Dateofsystem4 = formatdate4.format(SystemDate4);	
						//System.out.println(Dateofsystem4);
						String arr4[]=Dateofsystem4.split("/");
						String days4 = arr4[0];		
						int s4 = (int) Integer.parseInt(days4);
						String day4=String.valueOf(s4+d4); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
					  js4.executeScript("arguments[0].click()", datepicker4);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele4:alldaate4) 
					  {
						  String dt4 = ele4.getText();
						//  System.out.println(dt1);
						  

						   if(dt4.equals(day4))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele4.click();
							  break;
						  }
						 
					  }
					  
          //Select Truck for second leg Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

        }
    }
//	@Test(priority=27)
//	public void D2D_Postpaid_Double_leg_Wh2wh_SingleFlight_POMail_flow() throws InterruptedException, IOException{
//		homePage.verifyHomePageurl();
//		D2D_Booking_Page.ClickOnNew_order_AWB();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
//		
//		// Specify the path to your Excel file
//        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
//        
//     // Create a FileInputStream to read the Excel file
//        FileInputStream fis = new FileInputStream(new File(excelFilePath));
//        
//        // Create a workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        
//        // Get the first sheet (index 0)
//        XSSFSheet sheet = workbook.getSheetAt(24);
//        
//       int Lastrow = sheet.getLastRowNum();
//       
//       System.out.println("This is the last row count:- "+Lastrow);
//        // Iterate through rows
//        for (int i = 1; i<= 1; i++) {
//
//            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//  	
//        // To Enter Orging on top of the booking page	
//        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
//        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
//     		 System.out.println("This is my data value:- "+W_org);
//     		//Thread.sleep(1000);
//     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//    // To Enter Destination  on top of the booking page	
//       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
//       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
//   		 System.out.println("This is my data value:- "+W_des);
//    	// Thread.sleep(1000);
//    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//        		
//      // To Enter Commodity Code  on top of the booking page	
//          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
//          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
//      		 System.out.println("This is my data value:- "+com);
//       		Thread.sleep(3000);  
//       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//       		
//      // To Enter Shipper  on top of the booking page	
//         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
//         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
//     		 System.out.println("This is my data value:- "+ship);
//      		Thread.sleep(1000);		
//      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//      		
//      // To Enter Consignee   on top of the booking page	
//        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
//        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
//    		 System.out.println("This is my data value:- "+con);
//     		   		
//    	
//    // To Enter Pieces    on top of the booking page	
//       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
//       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
//   		 System.out.println("This is my data value:- "+pis);
//    		 	
//     
//    // To Enter Gross Weight (Kg)  on top of the booking page	
//          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
//          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
//      		 System.out.println("This is my data value:- "+gweight_B);
//       				
//    //Gross Weight Window Open
//				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//				Thread.sleep(2000);
//				
//				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
//				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
//				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
//				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height
//
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(1000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
//				 Thread.sleep(1000);
//		
//		// To Click on shipper details:-		 
//				 
//				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
//				 
//	    //To Shipper Invoice 
//				  
//				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
//				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
//					 
//	  //To DV for Carriage
//				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
//				
////----------select Fisrt Truck in route
//					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
//					 select.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//		//Select Route Destination
//				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//        //To Get Today Date
//				 		int d = 0;
//					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate = new Date();
//						String Dateofsystem = formatdate.format(SystemDate);	
//						//System.out.println(Dateofsystem);
//						String arr[]=Dateofsystem.split("/");
//						String days = arr[0];		
//						int s = (int) Integer.parseInt(days);
//						String day=String.valueOf(s+d); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js =(JavascriptExecutor)driver;
//					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
//					  js.executeScript("arguments[0].click()", datepicker);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele:alldaate) 
//					  {
//						  String dt = ele.getText();
//						//  System.out.println(dt);
//						  
//
//						   if(dt.equals(day))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele.click();
//							  break;
//						  }
//						 
//					  }
//					  
//       //Select Truck number Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
//					Thread.sleep(2000);
//					
//		
////-----------Second Truck Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
//					 select1.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d1 = 0;
//					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate1 = new Date();
//						String Dateofsystem1 = formatdate1.format(SystemDate1);	
//						//System.out.println(Dateofsystem1);
//						String arr1[]=Dateofsystem1.split("/");
//						String days1 = arr1[0];		
//						int s1 = (int) Integer.parseInt(days1);
//						String day1=String.valueOf(s1+d1); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
//					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
//					  js1.executeScript("arguments[0].click()", datepicker1);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele1:alldaate1) 
//					  {
//						  String dt1 = ele1.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt1.equals(day1))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele1.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Second Truck Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					//-----------Flight Selection in Second Leg
//
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//					
////-------To Select Fist leg Flight	
//					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
//					 select2.selectByVisibleText("Flight");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination
//				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d2 = 0;
//					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate2 = new Date();
//						String Dateofsystem2 = formatdate2.format(SystemDate2);	
//						//System.out.println(Dateofsystem1);
//						String arr2[]=Dateofsystem2.split("/");
//						String days2 = arr2[0];		
//						int s2 = (int) Integer.parseInt(days2);
//						String day2=String.valueOf(s2+d2); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
//					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
//					  js2.executeScript("arguments[0].click()", datepicker2);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele2:alldaate2) 
//					  {
//						  String dt2 = ele2.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt2.equals(day2))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele2.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//
//					
//					
////Destination First Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
//					select3.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination  via Warehouse
//				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d3 = 0;
//					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate3 = new Date();
//						String Dateofsystem3 = formatdate3.format(SystemDate3);	
//						//System.out.println(Dateofsystem3);
//						String arr3[]=Dateofsystem3.split("/");
//						String days3 = arr3[0];		
//						int s3 = (int) Integer.parseInt(days3);
//						String day3=String.valueOf(s3+d3); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
//					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
//					  js3.executeScript("arguments[0].click()", datepicker3);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele3:alldaate3) 
//					  {
//						  String dt3 = ele3.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt3.equals(day3))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele3.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Flight Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////Destination Second Truck Add------------------------------------------
//					//To Add new Route Button
//					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
//					Thread.sleep(1000);
//				//To Select second leg Flight	
//					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
//					select4.selectByVisibleText("Truck");
//					 Thread.sleep(1000);
//					 
//	//Select Route Destination  via Warehouse
//				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
//				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
//				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				 
//					 
//  //To Get Today Date
//				 		int d4 = 0;
//					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
//					  	Date SystemDate4 = new Date();
//						String Dateofsystem4 = formatdate4.format(SystemDate4);	
//						//System.out.println(Dateofsystem4);
//						String arr4[]=Dateofsystem4.split("/");
//						String days4 = arr4[0];		
//						int s4 = (int) Integer.parseInt(days4);
//						String day4=String.valueOf(s4+d4); 
//					//	System.out.println("This is the current day for today date"+ s);
//					  
//			//To Click the Datepicker in Route From Date
//					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
//					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
//					  js4.executeScript("arguments[0].click()", datepicker4);
//					  Thread.sleep(1000);
//					  
//			//To click the date in route date
//					  
//					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
//					  for(WebElement ele4:alldaate4) 
//					  {
//						  String dt4 = ele4.getText();
//						//  System.out.println(dt1);
//						  
//
//						   if(dt4.equals(day4))
//						  {
//							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
//							  
//							  ele4.click();
//							  break;
//						  }
//						 
//					  }
//					  
//          //Select Truck for second leg Code
//					  Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
//				//	Thread.sleep(2000);
//				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
//				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
//					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//					Thread.sleep(2000);
//					
////To Save Booking
//				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
//				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      	Thread.sleep(11000);	
//			      	
//					  
//		     		//To Capture the PopUp msg when we submit 
//		            
//		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
//		         System.out.println("Whai is error msg:- "+popupText );
//		    
//		        
//		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
//		         String newText = parts[0]; // Access the part after "is"
//		         
//		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//		         String newText1 = parts1[1]; // Access the part after "is"
//		         System.out.println(newText1);
//		          
//		 		Assert.assertEquals(" Saved ",newText1);
//		           
//					 
// // To Execute The AWB		  
//					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
//					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			    	  Thread.sleep(11000);	
// //To Accpet the AWB
//						
//					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
//					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
//					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
//					  
//					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//			      		Thread.sleep(3000);
//			      					  	  		
//        }
//    }
	@Test(priority=28)
	public void D2D_Postpaid_Double_leg_Wh2wh_SingleFlight_Walking_flow() throws InterruptedException, IOException{
		homePage.verifyHomePageurl();
		D2D_Booking_Page.ClickOnNew_order_AWB();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("url")+ "/create-booking");
		
		// Specify the path to your Excel file
        String excelFilePath = "C:\\Users\\devendra.singh1\\git\\Kargo360\\src\\main\\java\\com\\crm\\qa\\testdata\\D2D_Booking.xlsx";
        
     // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        
        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        // Get the first sheet (index 0)
        XSSFSheet sheet = workbook.getSheetAt(25);
        
       int Lastrow = sheet.getLastRowNum();
       
       System.out.println("This is the last row count:- "+Lastrow);
        // Iterate through rows
        for (int i = 1; i<= 1; i++) {

            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
  	
        // To Enter Orging on top of the booking page	
        	 String W_org  =  sheet.getRow(i).getCell(1).getStringCellValue(); 
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
        	 driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(W_org);
     		 System.out.println("This is my data value:- "+W_org);
     		//Thread.sleep(1000);
     		//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
    // To Enter Destination  on top of the booking page	
       	 String W_des  =  sheet.getRow(i).getCell(2).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='destination']")).click();
       	 driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(W_des);
   		 System.out.println("This is my data value:- "+W_des);
    	// Thread.sleep(1000);
    	// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        		
      // To Enter Commodity Code  on top of the booking page	
          	 String com  =  sheet.getRow(i).getCell(3).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
          	 driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
      		 System.out.println("This is my data value:- "+com);
       		Thread.sleep(3000);  
       	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       		
      // To Enter Shipper  on top of the booking page	
         	 String ship  =  sheet.getRow(i).getCell(4).getStringCellValue(); 
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
         	 driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(ship);
     		 System.out.println("This is my data value:- "+ship);
      		Thread.sleep(1000);		
      	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      		
      // To Enter Consignee   on top of the booking page	
        	 String con  =  sheet.getRow(i).getCell(5).getStringCellValue(); 
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
        	 driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(con);
    		 System.out.println("This is my data value:- "+con);
     		   		
    	
    // To Enter Pieces    on top of the booking page	
       	 String pis  =  sheet.getRow(i).getCell(6).getStringCellValue(); 
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).click();
       	 driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(pis);
   		 System.out.println("This is my data value:- "+pis);
    		 	
     
    // To Enter Gross Weight (Kg)  on top of the booking page	
          	 String gweight_B  =  sheet.getRow(i).getCell(7).getStringCellValue(); 
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).click();
          	 driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(gweight_B);
      		 System.out.println("This is my data value:- "+gweight_B);
       				
    //Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				
				 String gweight_l  =  sheet.getRow(i).getCell(8).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[2]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_l); //Length
				 String gweight_h  =  sheet.getRow(i).getCell(9).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c')]//child::tbody//child::tr//child::td[3]//input[contains(@class,'form-control ng-tns-c')][1]")).sendKeys(gweight_h); //Width
				 String gweight_w  =  sheet.getRow(i).getCell(10).getStringCellValue();
				 driver.findElement(By.xpath("//*[contains(@class,'table deminsion-table ng-tns-c25')]//child::tbody//child::tr//child::td[4]//input[contains(@class,'form-control ng-tns-c250')][1]")).sendKeys(gweight_w); //Height

				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(1000);
				 
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(1000);
		
		// To Click on shipper details:-		 
				 
				 driver.findElement(By.xpath("//*[contains(text(),' Shipper Details')]")).click();
				 
	    //To Shipper Invoice 
				  
				  String ship_inv  =  sheet.getRow(i).getCell(11).getStringCellValue();
				  driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys(ship_inv);
					 
	  //To DV for Carriage
				  String DV_car  =  sheet.getRow(i).getCell(12).getStringCellValue();
				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys(DV_car);			
				
//----------select Fisrt Truck in route
					Select select = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[1]//select")));
					 select.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
		//Select Route Destination
				  String W_via  =  sheet.getRow(i).getCell(17).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(W_via);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
        //To Get Today Date
				 		int d = 0;
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  
       //Select Truck number Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000);
					
		
//-----------Second Truck Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select1 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[1]//select")));
					 select1.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String org  =  sheet.getRow(i).getCell(13).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(org);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d1 = 0;
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate1 = new Date();
						String Dateofsystem1 = formatdate1.format(SystemDate1);	
						//System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr1[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d1); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  
          //Select Second Truck Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					//-----------Flight Selection in Second Leg

					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
//-------To Select Fist leg Flight	
					Select select2 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[1]//select")));
					 select2.selectByVisibleText("Flight");
					 Thread.sleep(1000);
					 
	//Select Route Destination
				  String des  =  sheet.getRow(i).getCell(14).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[3]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d2 = 0;
					  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate2 = new Date();
						String Dateofsystem2 = formatdate2.format(SystemDate2);	
						//System.out.println(Dateofsystem1);
						String arr2[]=Dateofsystem2.split("/");
						String days2 = arr2[0];		
						int s2 = (int) Integer.parseInt(days2);
						String day2=String.valueOf(s2+d2); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js2 =(JavascriptExecutor)driver;
					  WebElement datepicker2 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[6]//input"));
					  js2.executeScript("arguments[0].click()", datepicker2);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele2:alldaate2) 
					  {
						  String dt2 = ele2.getText();
						//  System.out.println(dt1);
						  

						   if(dt2.equals(day2))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele2.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[3]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(2000);

					
					
//Destination First Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select3 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[1]//select")));
					select3.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  String W_Via_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(W_Via_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[4]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d3 = 0;
					  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate3 = new Date();
						String Dateofsystem3 = formatdate3.format(SystemDate3);	
						//System.out.println(Dateofsystem3);
						String arr3[]=Dateofsystem3.split("/");
						String days3 = arr3[0];		
						int s3 = (int) Integer.parseInt(days3);
						String day3=String.valueOf(s3+d3); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js3 =(JavascriptExecutor)driver;
					  WebElement datepicker3 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[6]//input"));
					  js3.executeScript("arguments[0].click()", datepicker3);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele3:alldaate3) 
					  {
						  String dt3 = ele3.getText();
						//  System.out.println(dt1);
						  

						   if(dt3.equals(day3))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele3.click();
							  break;
						  }
						 
					  }
					  
          //Select Flight Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[4]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//Destination Second Truck Add------------------------------------------
					//To Add new Route Button
					driver.findElement(By.xpath("//*[@title='Add New Route']")).click();
					Thread.sleep(1000);
				//To Select second leg Flight	
					Select select4 = new Select(driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[1]//select")));
					select4.selectByVisibleText("Truck");
					 Thread.sleep(1000);
					 
	//Select Route Destination  via Warehouse
				  //String W_des  =  sheet.getRow(i).getCell(18).getStringCellValue();
				  driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(W_des);
				 driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv ng-tns')]//child::tbody//child::tr[5]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				 
					 
  //To Get Today Date
				 		int d4 = 0;
					  	DateFormat formatdate4 = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate4 = new Date();
						String Dateofsystem4 = formatdate4.format(SystemDate4);	
						//System.out.println(Dateofsystem4);
						String arr4[]=Dateofsystem4.split("/");
						String days4 = arr4[0];		
						int s4 = (int) Integer.parseInt(days4);
						String day4=String.valueOf(s4+d4); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js4 =(JavascriptExecutor)driver;
					  WebElement datepicker4 = driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[6]//input"));
					  js4.executeScript("arguments[0].click()", datepicker4);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate4 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele4:alldaate4) 
					  {
						  String dt4 = ele4.getText();
						//  System.out.println(dt1);
						  

						   if(dt4.equals(day4))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele4.click();
							  break;
						  }
						 
					  }
					  
          //Select Truck for second leg Code
					  Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("sg",Keys.ARROW_UP);
				//	Thread.sleep(2000);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[9]//select")).sendKeys(Keys.ARROW_DOWN);
				//	String flight = sheet.getRow(i).getCell(15).getStringCellValue();
					driver.findElement(By.xpath("//*[contains(@class,'table datatable-basic dataTable datatable-scroll no-footer route_dv')]//child::tbody//child::tr[5]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
					Thread.sleep(2000);
					
//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      	Thread.sleep(11000);	
			      	
					  
		     		//To Capture the PopUp msg when we submit 
		            
		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		         String popupText  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
		         System.out.println("Whai is error msg:- "+popupText );
		    
		        
		         String[] parts = popupText.split("Successfully"); // Split the text using "is" as a delimiter
		         String newText = parts[0]; // Access the part after "is"
		         
		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
		         String newText1 = parts1[1]; // Access the part after "is"
		         System.out.println(newText1);
		          
		 		Assert.assertEquals(" Saved ",newText1);
		           
					 
 // To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();		
					//  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	 // driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			    	  Thread.sleep(11000);	
 //To Accpet the AWB
						
					  driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(pis);  //Enter Pieces in accept Field
					  driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(gweight_B); 
					  driver.findElement(By.xpath("//button[@title='Accept']")).click();
					  
					  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		Thread.sleep(3000);

//To Collect Button
			      	  
			      	    	  driver.findElement(By.xpath("//button[@title='Collect']")).click();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).isDisplayed();
			      	    	  Thread.sleep(2000);
			      	    	  driver.findElement(By.xpath("//*[@title='Pay']")).click();
			      	    	  Thread.sleep(3000);
			      	    	//To Capture the Collect Msg PopUp
			      	            
			      		     	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			      		         String Collectmsg  = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
			      		         System.out.println("Whai is error msg:- "+Collectmsg );
			      		    
			      		        
			      		         String[] partc = Collectmsg.split("Collecion"); // Split the text using "is" as a delimiter
			      		         String newTextmsg = partc[1]; // Access the part after "is"
			      		         
//			      		         String[] parts1 = newText.split("AXB"); // Split the text using "is" as a delimiter
//			      		         String newText1 = parts1[1]; // Access the part after "is"
			      		         System.out.println(newTextmsg);
			      		          
			      		 		Assert.assertEquals(" Successfully Submitted",newTextmsg);
			      					  	  		
        }
    }

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	

