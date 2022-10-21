package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddItemToChart {
    private final WebDriver driver;
    private final By allItems = By.className("s-product-image-container");
    private final By addChart = By.id("add-to-cart-button");

    public AddItemToChart(WebDriver driver){
        this.driver = driver;
    }
    public OpenChart clearChart() {
        //List<WebElement> firstItem = driver.findElements(allItems);
        //firstItem.get(0).click();
        driver.findElement(addChart).click();
        return new OpenChart(driver);
    }
}
