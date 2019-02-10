package Homework.hw6.ex1;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:hw6",
        glue = "classpath:Homework.hw6.ex1.Steps"
)

public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void driverSetup(){
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
