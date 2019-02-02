package lesson3;

import base.lesson3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PageObjectTest {

    WebDriver driver;
    IndexPage indexPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void simpleTest() {

        //2
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3
        assertEquals(driver.getTitle(), "Home Page");

        //4 login
        indexPage.login("epam", "1234");
        //5
        driver.close();
    }
}
