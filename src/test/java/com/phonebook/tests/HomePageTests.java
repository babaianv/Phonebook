package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!isHomeComponentPresent()){
            click(By.cssSelector("[href='/home']"));
        }
    }

    @Test
    public void isHomeComponentPresentTest(){
//        System.out.println("Home page is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

}

