package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

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

        //click on add link
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Adam");
        //enter last name
        type(By.cssSelector("input:nth-child(2)"), "Karl");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        //enter desc
        type(By.cssSelector("input:nth-child(6)"), "teacher");

        //click on the same button
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactTest(){
       int sizeBefore = sizeOfContacts();

        //click on the cart
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click remove
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts(){
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

}

