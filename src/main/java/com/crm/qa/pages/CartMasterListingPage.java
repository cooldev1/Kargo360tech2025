package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class CartMasterListingPage extends TestBase {

	TestUtil testUtil;
	
	// Open Orgnaze and Masters
	
		@FindBy(xpath = "//span[contains(text(),' Organize ')]")
		@CacheLookup
		WebElement Organize;

		@FindBy(xpath = "//a[contains(text(),' Masters ')][1]")
		WebElement Masters;
		
		@FindBy(xpath = "//a[contains(text(),' Finance ')][1]")
		WebElement Finance;
		
		@FindBy(xpath = "//a[@href='/cart/list']")
		WebElement Cart;
	
		@FindBy(xpath = "//*[@title='Advanced Filters']")
		WebElement advflt;
		
		@FindBy(xpath = "//*[@formcontrolname='cart']")
		WebElement Cartno;
		
		@FindBy(xpath = "//*[@formcontrolname='cart_description']")
		WebElement Cartdes;
		
		@FindBy(xpath = "//*[@formcontrolname='origin']")
		WebElement stationcode;
		
		@FindBy(xpath = "//*[@formcontrolname='status']")
		WebElement status;
		
		@FindBy(xpath = "//*[@title='Search']")
		WebElement searchbtn;
		
		@FindBy(xpath = "//*[@title='Refresh']")
		WebElement Refreshbtn;
		
		@FindBy(xpath = "//*[@title='Download']")
		WebElement downloadbtn;
		
		@FindBy(xpath = "//*[@title='Create Cart']")
		WebElement createCartbtn;
		
		@FindBy(xpath = "//span[contains(text(),' Next   ')]")
		WebElement Nextbtn_paginationbtn;
		
		@FindBy(xpath = "//input[@formcontrolname='from_date']")
		WebElement fromDate;
	
		@FindBy(xpath = "//input[@formcontrolname='to_date']")
		WebElement toDate;
		
	// Initializing the Page Objects:
	public CartMasterListingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCartListingPage() throws InterruptedException{
		
		testUtil = new TestUtil();
    	
		Actions action = new Actions(driver);
		action.moveToElement(Organize).build().perform();
		action.moveToElement(Masters).build().perform();
		action.moveToElement(Finance).build().perform();		
		Cart.click();
		// Using reusable method for verification
		testUtil.verifyElementVisibility(By.xpath("//button[@title='Advanced Filters']"), "Advance Button Should be show", 10);
		driver.findElement(By.xpath("//input[@formcontrolname='cart']")).click();
		
//		 // Find the element you want to click
//        WebElement element = driver.findElement(By.xpath("//button[@title='Advanced Filters']"));
//		 // Use JavaScript Executor to click on the element
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);
	}
	
	
	
	public String veryfyCartLisingpage(){
		return driver.getCurrentUrl();	
	}	
	
	
	public void clickonadvflt() throws InterruptedException{
	advflt.click();
	}
	public void clickon_searchbtn() throws InterruptedException{
	searchbtn.click();		
}
	public void clickon_Refreshbtn() throws InterruptedException{
	Refreshbtn.click();
}
	public void clickon_downloadbtn() throws InterruptedException{
	downloadbtn.click();
}
	public void clickon_createCartbtn() throws InterruptedException{
	createCartbtn.click();		
}
	public void clickon_paginationbtn() throws InterruptedException{
		Nextbtn_paginationbtn.isDisplayed();		
}

	public void clickon_Next_Paginationbtn() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),' Next   ')]")));
		nextButton.click();
//		Nextbtn_paginationbtn.click();		
}
	
	
}
