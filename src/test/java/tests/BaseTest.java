package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.FirstPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    protected FirstPage firstPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");

        firstPage = new FirstPage(driver);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
