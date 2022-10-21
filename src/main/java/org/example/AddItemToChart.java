package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddItemToChart {
    private final WebDriver driver;
    private final By addChart = By.id("add-to-cart-button");
    private final By openChart = By.id("nav-cart-count-container");
    public AddItemToChart(WebDriver driver){
        this.driver = driver;
    }
    public OpenChart clearChart() {
        driver.findElement(addChart).click();
        driver.findElement(openChart).click();
        return new OpenChart(driver);
    }
}
