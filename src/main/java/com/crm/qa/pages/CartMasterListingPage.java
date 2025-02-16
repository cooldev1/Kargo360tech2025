package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class CartMasterListingPage extends TestBase {

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
		
		@FindBy(xpath = "//a[@href='/cart/list']")
		WebElement paginationbtn;
	
	// Initializing the Page Objects:
	public CartMasterListingPage() {
		PageFactory.initElements(driver, this);
	}
	


	
	public void clickOnCartListingPage() throws InterruptedException{
		
		WebElement Statusboxshowing = driver.findElement(By.xpath("//span[contains(text(),'Delivered AXB')]"));
    	WebDriverWait wait = new WebDriverWait(driver, 10); // Use int instead of Duration
    	wait.until(ExpectedConditions.textToBePresentInElement(Statusboxshowing, ""));
    	
		Actions action = new Actions(driver);
		action.moveToElement(Organize).build().perform();
		action.moveToElement(Masters).build().perform();
		action.moveToElement(Finance).build().perform();		
		Cart.click();
		
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
	paginationbtn.isDisplayed();		
}

}
