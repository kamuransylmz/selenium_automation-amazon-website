package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninEMail {
    private final WebDriver driver;
    private final By apMailArea = By.id("ap_email");
    private final By continueBtn = By.id("continue");

    public SigninEMail(WebDriver driver){
        this.driver = driver;
    }

    public void setEMail(String email){
        driver.findElement(apMailArea).sendKeys(email);
    }
    public SigninPass getSignPassPage(){
        driver.findElement(continueBtn).click();
        return new SigninPass(driver);
    }
}
