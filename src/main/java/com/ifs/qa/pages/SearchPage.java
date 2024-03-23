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
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;

public class SearchPage extends TestBase {

    @FindBy(xpath ="//textarea[@title='Search']")
    @CacheLookup
    WebElement googlesearchbox;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/']/h3")
    @CacheLookup
    WebElement amazonLink;

    @FindBy(xpath = "//a[@href='/contacts/new']")
    @CacheLookup
    WebElement createNewContact;



    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();

    }
    public void searchInGoogle(String searchText) {
    	googlesearchbox.sendKeys(searchText);
    	googlesearchbox.sendKeys(Keys.ENTER);
    }
    public void clickOnSearchResult() {
    	amazonLink.click();
    }
}
