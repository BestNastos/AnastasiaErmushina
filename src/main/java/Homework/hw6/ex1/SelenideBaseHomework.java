package Homework.hw6.ex1;

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
