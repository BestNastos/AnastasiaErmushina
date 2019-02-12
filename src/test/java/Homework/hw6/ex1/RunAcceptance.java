package Homework.hw6.ex1;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(
        features = "classpath:hw6", //tags="@DifferentElementsInterface, @UserTableInterface",
        glue = "classpath:Homework.hw6.ex1.Steps"
)

public class RunAcceptance extends AbstractTestNGCucumberTests {
    @Before
    public void driverSetup() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        System.out.println("BEFOREE");
    }

    @After
    public void driverClose() {
        getWebDriver().manage().deleteAllCookies();
        close();
        System.out.println("AFTERRRR");
    }
}
