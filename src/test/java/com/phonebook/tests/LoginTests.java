package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        //if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            //click on sign out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }

    @Test
    public void loginPositiveTest(){

        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "babqa123@gmail.com");

        //enter password
        type(By.name("password"), "Qwerty123$");

        //click on the Login button
        click(By.name("login"));

        //assert Sign put present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }





}

