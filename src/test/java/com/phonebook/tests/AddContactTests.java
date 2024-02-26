package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{

    //precondition
    @BeforeMethod
    public void precondition(){

        //if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            //click on sign out button
            click(By.xpath("//button[.='Sign Out']"));
        }

        //click on Login link
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "babqa123@gmail.com");

        //enter password
        type(By.name("password"), "Qwerty123$");

        //click on the Login button
        click(By.name("login"));
    }


    @Test
    public void addContactPositiveTest(){
        //click on add link
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Vika");
        //enter last name
        type(By.cssSelector("input:nth-child(2)"), "Jer");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "vik88@gm.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        //enter desc
        type(By.cssSelector("input:nth-child(6)"), "teacher");

        //click on the same button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert contact is added by name
        Assert.assertTrue(isContactCreatedByText("Vika"));
    };

    @AfterMethod
    public void postCondition(){
        //click on the cart
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click remove
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactCreatedByText(String text){

        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts){
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

}

