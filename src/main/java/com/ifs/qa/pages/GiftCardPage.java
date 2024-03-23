package com.ifs.qa.pages;

import com.ifs.qa.base.TestBase;
import com.ifs.qa.util.TestUtil;

import org.openqa.selenium.By;
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

public class GiftCardPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 50); 
	
    @FindBy(xpath ="//ul[@id='gc-design-mini-picker']/li[1]")
    @CacheLookup
    WebElement giftcardDesign;
    @FindBy(id ="gc-live-preview-amount")
    @CacheLookup
    WebElement ammountText;

    public GiftCardPage(){
        PageFactory.initElements(driver, this);
    }

    public void selectGiftCardDesign(){
    	giftcardDesign.click();

    }
    public void selectAmount(int ammount) {
    	driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1' and @value='"+ammount+"']")).click();
    }
    public String getAmmountText() {
    	return ammountText.getText();
    }
}
