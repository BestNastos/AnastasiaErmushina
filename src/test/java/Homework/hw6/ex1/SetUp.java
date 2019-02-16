package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.HomePageInfo;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SetUp {

    @Given("^I open '([^\"]*)'$")
    public void iOpenURL(HomePageInfo url) {
        open(url.toString());
        getWebDriver().manage().window().maximize();
    }

    @After
    public void driverClose() {
        close();
    }
}
