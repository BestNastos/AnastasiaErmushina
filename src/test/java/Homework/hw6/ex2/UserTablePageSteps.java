package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.TableUsername;
import Homework.hw6.ex2.Enums.UserTablePageInfo;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class UserTablePageSteps {

    UserTablePage userTablePage = page(UserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(UserTablePageInfo title) {
        userTablePage.checkTitle(title);
    }


    @And("^6 NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void sixNumberTypeDropdownsAreDisplayed() {
        userTablePage.checkNumberTypeDropdowns();
    }

    @And("^6 User names are displayed on Users Table on User Table Page$")
    public void sixUsernamesAreDisplayed() {
        userTablePage.checkUsernames();
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void sixDescriptionImagesAreDisplayed() {
        userTablePage.checkDescriptionImages();
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void sixTextsUnderImagesAreDisplayed() {
        userTablePage.checkTextsUnderImages();
    }

    @And("^6 checkboxes are displayed on Users Table on User Table Page$")
    public void sixCheckboxesAreDisplayed() {
        userTablePage.checkVipCheckboxes();
    }

    @Then("^User table contains following values:$")
    public void userTableContainsValues(DataTable dataTable) {
        userTablePage.checkUserTableContainsElements(dataTable);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void iSelectVipCheckbox(TableUsername name) {
        userTablePage.selectVipBox(name);
    }

    @Then("^1 log row has '([^\"]*)' text in log section$")
    public void topLogRowShowsChangeOfStatus(String message) {
        userTablePage.checkLogForVipBox(message);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnColumnTypeForUser(TableUsername name) {
        userTablePage.openDropdownColumnTypeForUser(name);
    }

    @Then("^Droplist contains values$")
    public void dropdownContainsValues(List<String> values) {
        userTablePage.checkDropdownHasValues(values);
    }
}
