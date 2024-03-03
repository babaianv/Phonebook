package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        //if login link is not present
        if (!app.getUser().isLoginLinkPresent()){
            //click on sign out button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest(){

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("babqa123@gmail.com")
                .setPassword("Qwerty123$"));

        app.getUser().clickOnRegistrationButton();

        //asser Sign Out button is present
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

        Assert.assertTrue(app.getUser().isAlertAppears());
    }

}

