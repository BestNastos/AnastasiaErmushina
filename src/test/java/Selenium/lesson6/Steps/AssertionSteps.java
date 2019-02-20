package Selenium.lesson6.Steps;

import Selenium.lesson6.SelenideIndexPage;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Condition.text;

public class AssertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void usernameSHouldBe(String expectedName){
        new SelenideIndexPage().getUserName().shouldBe(text(expectedName));
    }
}
