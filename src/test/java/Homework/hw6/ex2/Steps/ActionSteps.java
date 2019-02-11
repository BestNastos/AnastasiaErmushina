package Homework.hw6.ex2.Steps;

import Homework.hw6.ex2.Enums.UserCredentials;
import Homework.hw6.ex2.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void iLogin(UserCredentials user){
        homePage.login(user);
    }

    @When("^I click on 'Service' button in Header$")
    public void iClickOnService(){
        homePage.openServiceMenu();
    }

    @And("^I click on 'User Table' button in Service dropdown$")
    public void iClickOnUserTable(){
        homePage.openUserTablePage();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void iSelectVipCheckbox(){
    // takes enum or string as a paramerer?
    }

}