package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.HomePageInfo;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class SetUp {

    @Given("^I am on '([^\"]*)'$")
    public void iOpenSite(HomePageInfo title) {
        open(title.toString());
    }
}
