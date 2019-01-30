package lesson4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideSimpleTest {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
       // Configuration.pollingInterval =

    }

    @Test
    public void simpleTest() {

        // 1
        // по умолчанию хром, если хотим поменять:
        // Configuration.browser = Browsers.FIREFOX;
        // не нужно будет скачивать драйверы, он все сам

        //2
        open("https://epam.github.io/JDI/index.html");

        //3
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        $("#user-name").shouldHave(text("PETER CHAILOVSKII"));

        //5
        close();
    }
}
