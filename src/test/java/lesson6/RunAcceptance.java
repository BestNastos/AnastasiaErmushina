package lesson6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:lesson6", //correct
        glue = "classpath:lesson6.Steps" //read about options incl. filtering of scenarios
)

public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void driverSetup(){
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
