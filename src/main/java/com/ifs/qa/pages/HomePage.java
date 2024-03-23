package com.ifs.qa.pages;

import com.ifs.qa.base.TestBase;
import com.ifs.qa.util.TestUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;

public class HomePage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 50); 
	
    @FindBy(xpath ="//textarea[@title='Search']")
    @CacheLookup
    WebElement googlesearchbox;

    @FindBy(id = "GLUXCountryList")
    @CacheLookup
    WebElement countryDropdown;

    @FindBy(id = "nav-global-location-popover-link")
    @CacheLookup
    WebElement deliverToBtn;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/']/h3")
    @CacheLookup
    WebElement amazonLink;
    @FindBy(xpath = "//button[text()='Done']")
    @CacheLookup
    WebElement doneBtn;
    @FindBy(id = "glow-ingress-line2")
    @CacheLookup
    WebElement deliverToText;
    @FindBy(id = "GLUXCountryValue")
    @CacheLookup
    WebElement SelectedTextdropdown;
    @FindBy(id = "twotabsearchtextbox")
    @CacheLookup
    WebElement searchBox;
    
    @FindBy(id = "//a/span[text()='Amazon.com eGift Card']")
    @CacheLookup
    WebElement eGiftCardText;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();

    }
    public void clickOnBtnDeliverTo() {
    	deliverToBtn.click();
    }
    public void selectDeliverCountry(String country) throws InterruptedException {
    	Select objSelect = new Select(countryDropdown);
    	objSelect.selectByVisibleText(country);
    	wait.until(ExpectedConditions.textToBePresentInElement(SelectedTextdropdown, country));
    	doneBtn.click();
    	Thread.sleep(3000);
//    	wait.until(ExpectedConditions.textToBePresentInElement(deliverToText, country));
    	 
    }
    public String getDeliverToText() {
//    	wait.until(ExpectedConditions.textToBePresentInElement(deliverToText, "India"));
    	return deliverToText.getText();
    }
    public void searchTextOnsearchBox(String searchText) {
    	searchBox.sendKeys(searchText);
    	searchBox.sendKeys(Keys.ENTER);
    }
    public void clickOnAmazoneGiftCardLink() throws InterruptedException {
    	
    	scrollInToElement(eGiftCardText);
    	eGiftCardText.click();
    }
    
    public void scrollInToElement(WebElement element) throws InterruptedException {
//    	Actions actions = new Actions(driver);
//    	actions.moveToElement(element);
//    	actions.perform();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    	Thread.sleep(1000);
    }
   
}
