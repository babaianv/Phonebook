package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        //if login link is not present
        if (!isLoginLinkPresent()){
            //click on sign out button
            clickOnSignOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest(){

        clickOnLoginLink();

        fillLoginRegisterForm(new User()
                .setEmail("babqa123@gmail.com")
                .setPassword("Qwerty123$"));

        clickOnRegistrationButton();

        //asser Sign Out button is present
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

        Assert.assertTrue(isAlertAppears());
    }

}

