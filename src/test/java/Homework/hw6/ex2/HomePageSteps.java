package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.UserCredentials;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class HomePageSteps {

    private HomePage homePage = page(HomePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void iLogin(UserCredentials user) {
        homePage.login(user);
    }

    @When("^I click on 'Service' button in Header$")
    public void iClickOnService() {
        homePage.openServiceMenu();
    }

    @And("^I click on 'User Table' button in Service dropdown$")
    public void iClickOnUserTable() {
        homePage.openUserTablePage();
    }
}
