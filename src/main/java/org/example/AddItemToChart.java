package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddItemToChart {
    private final WebDriver driver;
    private final By deleteItemFromChart = By.xpath("//input[@value='Sil']");

    public AddItemToChart(WebDriver driver){
        this.driver = driver;
    }
    public void clearChart() {
        driver.findElement(deleteItemFromChart).click();
    }
}
