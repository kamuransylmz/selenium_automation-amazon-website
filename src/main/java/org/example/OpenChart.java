package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenChart {
    WebDriver driver;
    private final By deleteItemFromChart = By.xpath("//input[@value='Sil']");
    private final By openChart = By.id("nav-cart-count-container");

    public OpenChart(WebDriver driver){
        this.driver = driver;
    }

    public void deleteItems(){
        driver.findElement(openChart).click();
        driver.findElement(deleteItemFromChart).click();
    }

}

