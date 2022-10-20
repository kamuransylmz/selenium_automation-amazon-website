package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
        //This is the main class and just call functions

        private final WebDriver driver;
        private final By searchDropdownBox = By.id("nav-search-dropdown-card");
        private final By computers = By.id("searchDropdownBox");
        private final By twotabsearchtextbox = By.id("twotabsearchtextbox");
        private final By searchBtn = By.id("nav-search-submit-button");
        private final By onlyLaptopItems = By.xpath("//*[@id='departments']/ul/li[8]");
        private final By checkBoxPrime = By.xpath("//li[@id = 'p_85/21345931031']/span");
        private final By allItems = By.className("s-product-image-container");
        private final By primeItems = By.xpath("//span[contains(@class,'aok-relative')]");
        private final By addChart = By.id("add-to-cart-button");
        private final By openChart = By.id("nav-cart-count-container");

        public MainPage(WebDriver driver){
            this.driver = driver;
        }

        public String selectCategories() {
                //selecting categories
                driver.findElement(searchDropdownBox).click();

                WebElement comp = driver.findElement(computers);
                Select select = new Select(comp); //selecting specific category
                select.selectByVisibleText("Bilgisayarlar");

                //System.out.println(select.getFirstSelectedOption().getText());

                return select.getFirstSelectedOption().getText();

        }
        public String searchBox() {
                // search whatever you want
                driver.findElement(twotabsearchtextbox).sendKeys("lenovo ideapad gaming 3");
                driver.findElement(searchBtn).click();

                String testDropdownList = driver.findElement(twotabsearchtextbox).getAttribute("value");

                driver.findElement(onlyLaptopItems).click();
                driver.findElement(checkBoxPrime).click();

                return testDropdownList;
        }
        public void verifyAllItemsIsPrime() {
                waitFor(allItems);
                List<WebElement> allItemsLocator = driver.findElements(allItems);
                System.out.println("All items number are: " + allItemsLocator.size());

                waitFor(primeItems);
                List<WebElement>  primeItemsLocator = driver.findElements(primeItems);
                System.out.println("Prime items number are: " + primeItemsLocator.size());

                //Verfy in TEST CLASS
                if (allItemsLocator.size() == primeItemsLocator.size()) {
                        System.out.println("*** " + "All items is prime product" + " ***");
                }else {
                        System.out.println("All items and Prime items DOES NOT match!!!");
                }

        }

        public void waitFor(By Locator){
                WebDriverWait wait = new WebDriverWait(driver,5);
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
        }

        public void addPrimeItemsToChart() {
                List<WebElement> firstItem = driver.findElements(allItems);
                firstItem.get(0).click();

                driver.findElement(addChart).click();
        }
        public AddItemToChart getChart(){

                driver.findElement(openChart).click();
                return new AddItemToChart(driver);
        }


        //AmazonProject amazonProject = new AmazonProject();
        //amazonProject.openLoginPageAmazon();
        //amazonProject.loginAmazon("kamuransylmz@gmail.com","sylmz123");
        //amazonProject.selectCategories();
        //amazonProject.searchBox();
        //amazonProject.verifyAllItemsIsPrime();
        //amazonProject.addPrimeItemsToChart();
        //amazonProject.clearChart();

}