package Homework.hw2.ex3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBaseHomework {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
    }
}
