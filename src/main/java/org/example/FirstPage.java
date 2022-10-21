package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FirstPage {

    private final WebDriver driver;
    private final By loginLocator = By.id("nav-link-accountList-nav-line-1");
    public FirstPage(WebDriver driver){
        this.driver = driver;
    }
    public SigninEMail loginEMail(){
        WebElement loginToolTip = driver.findElement(loginLocator);

        Actions action = new Actions(driver);
        action.moveToElement(loginToolTip).perform(); // to perform login button or toolTip

        driver.findElement(loginLocator).click();
        return new SigninEMail(driver);
    }
}
