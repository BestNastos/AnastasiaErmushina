package Homework.hw6.ex2.Steps;

import Homework.hw6.ex2.Enums.TableUsername;
import Homework.hw6.ex2.Enums.UserCredentials;
import Homework.hw6.ex2.HomePage;
import Homework.hw6.ex2.UserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

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

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckbox(TableUsername name) {
        userTablePage.selectVipBox(name);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnColumnTypeForUser(TableUsername name) {
        userTablePage.openDropdownColumnTypeForUser(name);
    }

}
