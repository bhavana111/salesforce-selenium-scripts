package com.salesforce.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.*;

import org.openqa.selenium.WebElement;


public class SFDCLogin {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver(); // Starting Firefox browser
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://login.salesforce.com");

        Assert.assertEquals(driver.getTitle(), "Login | Salesforce");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));

        Assert.assertTrue(userName.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
        System.out.println("Verified UI elements on Login page");

        userName.sendKeys(""); // Enter userName
        Thread.sleep(2000);
        password.sendKeys(""); // Enter password
        Thread.sleep(2000);
        loginButton.click();

        WebElement searchOnDashboard = driver.findElement(By.xpath("//input[@id='phSearchInput']"));

        Assert.assertTrue(searchOnDashboard.isDisplayed());
        System.out.println("Successful log in to Salesforce");

        driver.quit(); //Quitting browser
    }

	/* While running test script, you will have to skip verification code step.Follow this :
	 * Login to Salesforce > Click on Setup > Search for Network Access > New > Add IP range > Save 
	 * 
	 * Running from Jenkins server, add Jenkins IP in Trusted IP range
	 * Running from your local, add network IP range from *.*.*.0 to *.*.*.255 in trusted IP range */

}
