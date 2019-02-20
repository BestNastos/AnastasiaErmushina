package Selenium.lesson4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PageObjectSelenideTest extends SelenideBase {

    SelenideIndexPage selenideIndexPage;

    @BeforeMethod
    public void beforeMethod() {
        open("https://epam.github.io/JDI/index.html");
        selenideIndexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void simpleTest() {
        selenideIndexPage.login("epam", "1234");
    }
}
