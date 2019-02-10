package Homework.hw6.ex2.Steps;

import Homework.hw6.ex2.Enums.HomePageInfo;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    @Given("^I am on 'Home Page'$")
    public void iOpenEpamSite(){
        open(HomePageInfo.URL.toString());
    }
}
