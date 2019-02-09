package Homework.hw5.ex1.hw4ex2WithAllureAnnotations;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBaseHomework {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }
}
