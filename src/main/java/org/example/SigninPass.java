package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPass {
    private final WebDriver driver;
    private final By passwordArea = By.id("ap_password");
    private final By loginBtn = By.id("signInSubmit");
    public SigninPass(WebDriver driver){
        this.driver = driver;
    }
    public void setPass(String password){
        driver.findElement(passwordArea).sendKeys(password);
    }
    public void getMainPage(){
        driver.findElement(loginBtn).click();
    }
}
