package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.HomePageInfo;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SetUp {

    @Given("^I am on '([^\"]*)'$")
    public void iOpenSite(HomePageInfo title) {
        open(title.toString());
        getWebDriver().manage().window().maximize();
    }
}
