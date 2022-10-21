package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
        private final WebDriver driver;
        private final By searchDropdownBox = By.id("nav-search-dropdown-card");
        private final By computers = By.id("searchDropdownBox");
        private final By twotabsearchtextbox = By.id("twotabsearchtextbox");
        private final By searchBtn = By.id("nav-search-submit-button");
        private final By onlyLaptopItems = By.xpath("//*[@id='departments']/ul/li[8]");
        private final By checkBoxPrime = By.xpath("//li[@id = 'p_85/21345931031']/span");
        private final By allItems = By.className("s-product-image-container");
        private final By primeItems = By.xpath("//span[contains(@class,'aok-relative')]");
        public MainPage(WebDriver driver){
            this.driver = driver;
        }
        public List<String> selectCategories(String option) {
                findDropdownElement().selectByVisibleText(option);
                driver.findElement(searchDropdownBox).click();
                List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
                return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
        }
        private Select findDropdownElement(){
                return new Select(driver.findElement(computers));
        }
        public String searchBox(String searchForProduct) {
                driver.findElement(twotabsearchtextbox).sendKeys(searchForProduct);
                driver.findElement(searchBtn).click();

                String testDropdownList = driver.findElement(twotabsearchtextbox).getAttribute("value");

                driver.findElement(onlyLaptopItems).click();
                driver.findElement(checkBoxPrime).click();

                return testDropdownList;
        }
        public List<WebElement> verifyAllItemsArePrime1() {
                waitFor(allItems);
                return driver.findElements(allItems);
        }
        public List<WebElement> verifyAllItemsArePrime2() {
                waitFor(primeItems);
                return driver.findElements(primeItems);
        }
        private void waitFor(By Locator){
                WebDriverWait wait = new WebDriverWait(driver,5);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
        }
        public AddItemToChart addPrimeItemsToChart() {
                List<WebElement> firstItem = driver.findElements(allItems);
                firstItem.get(0).click();
                return new AddItemToChart(driver);
        }
}