package com.ifs.qa.test;

import com.ifs.qa.base.TestBase;
import com.ifs.qa.pages.ContactsPage;
import com.ifs.qa.pages.HomePage;
import com.ifs.qa.pages.LoginPage;
import com.ifs.qa.pages.SearchPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;
    ContactsPage contactsPage;
    public HomePageTest(){
         super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        searchPage = new SearchPage();
       homePage = new HomePage();
    }
    @Test
    public void homePageTitleTest() {
    	searchPage.searchInGoogle("Amzon");
    	searchPage.clickOnSearchResult();
        String title = homePage.validateHomePageTitle();
        Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");

    }
    @Test
    public void verifyDeliverButtonTextUpdated() throws InterruptedException{
    	searchPage.searchInGoogle("Amzon");
    	searchPage.clickOnSearchResult();
    	homePage.clickOnBtnDeliverTo();
    	homePage.selectDeliverCountry("India");
    	Assert.assertEquals(homePage.getDeliverToText(), "India");
    	
    }

    @AfterMethod
    public void tearDown(){

//        driver.quit();
    }

}


