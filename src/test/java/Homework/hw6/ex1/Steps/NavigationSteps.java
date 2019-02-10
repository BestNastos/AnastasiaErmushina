package Homework.hw6.ex1.Steps;

import Homework.hw6.ex1.Enums.HomePageInfo;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

        @Given("^I open site$")
        public void iOpenEpamSite(){
            open(HomePageInfo.URL.toString());
        }
}
