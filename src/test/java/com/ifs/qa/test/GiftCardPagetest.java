package com.ifs.qa.test;

import com.ifs.qa.base.TestBase;
import com.ifs.qa.pages.ContactsPage;
import com.ifs.qa.pages.GiftCardPage;
import com.ifs.qa.pages.HomePage;
import com.ifs.qa.pages.LoginPage;
import com.ifs.qa.pages.SearchPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GiftCardPagetest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;
    ContactsPage contactsPage;
    GiftCardPage giftcardPage;
    public GiftCardPagetest(){
         super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        
        searchPage = new SearchPage();
       homePage = new HomePage();
       giftcardPage = new GiftCardPage();
    }

    @Test
    public void verifyDeliverButtonTextUpdated() throws InterruptedException{
    	searchPage.searchInGoogle("Amzon");
    	searchPage.clickOnSearchResult();
//    	homePage.clickOnBtnDeliverTo();
//    	homePage.selectDeliverCountry("India");
    	homePage.searchTextOnsearchBox("e gift card Amazon");
    	homePage.clickOnAmazoneGiftCardLink();
    	giftcardPage.selectGiftCardDesign();
    	
    }
    @Test
    public void verifyChangeAmmount() throws InterruptedException{
    	searchPage.searchInGoogle("Amzon");
    	searchPage.clickOnSearchResult();
//    	homePage.clickOnBtnDeliverTo();
//    	homePage.selectDeliverCountry("India");
    	homePage.searchTextOnsearchBox("e gift card Amazon");
    	homePage.clickOnAmazoneGiftCardLink();
    	giftcardPage.selectGiftCardDesign();
    	giftcardPage.selectAmount(75);
    	Assert.assertEquals(giftcardPage.getAmmountText(), "$75");
    }

    @AfterMethod
    public void tearDown(){

//        driver.quit();
    }

}


