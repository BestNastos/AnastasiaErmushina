package lesson3;

import base.SeleniumBase;
import base.lesson3.IndexPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageObjectTest extends SeleniumBase {

    private IndexPage indexPage;

    @BeforeMethod
    public void initTest(){
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void SimpleTest(){
        indexPage.open();
        indexPage.login("Anastasia", "123");
    }
}
