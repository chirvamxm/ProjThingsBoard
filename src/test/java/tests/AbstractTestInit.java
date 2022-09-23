package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTestInit extends Base {

    //type name of the browser you're using in this variable (chrome or firefox)
    private static final String BROWSER_NAME = "chrome";

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        switch (BROWSER_NAME) {
            case ("chrome") -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case ("firefox") -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new Exception("You chose not valid browser!");
        }
    }

    @AfterMethod
    public void finishSession() {
        driver.quit();
    }

    public void goToSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean urlContains(String urlPath) {
        return driver.getCurrentUrl().contains(urlPath);
    }

    public boolean invisibilityOfElement(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return false;
        } catch (WebDriverException e) {
            return true;
        }
    }
}