package Homework.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class POWebsiteDisplayTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void simpleTest() {
        //2
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //3
        assertEquals(driver.getTitle(), "Home Page");
        //4 login
        homePage.login("epam", "1234");
        //5
        driver.close();
    }


    /*@Test
    public void simpleTest() {

        //1
        homePage.open(*//*homepagedata.url*//*);

        //2
        // checktitle(title)
        assertEquals(driver.getTitle(), "Home Page");

        //3 login
        // передаем Users.PETER
        homePage.login("epam", "1234");


        //4
        // можно ли перенести в HomePage assert? TODO
        assertEquals(homePage.getUserName().getText(), "PITER CHAILOVSKII");

        //6/
        //indpage.checknavigationitems
    }*/
}
