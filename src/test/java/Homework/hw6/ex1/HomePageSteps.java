package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.HomePageInfo;
import Homework.hw6.ex1.Enums.ServiceSubmenu;
import Homework.hw6.ex1.Enums.WebUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class HomePageSteps {

    private HomePage homePage = page(HomePage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBe(HomePageInfo browserTitle) {
        homePage.checkTitle(browserTitle);
    }

    @When("^I login as '([^\"]*)'$")
    public void iLoginAs(WebUser user){
        homePage.login(user);
    }

    @Then("^Username should be '([^\"]*)'$")
    public void usernameShouldBe(WebUser expectedName) {
        homePage.checkIfUsernameIsCorrect(expectedName);
    }

    @And("^Home Page should have '(\\d+)' benefit icons$")
    public void interfaceShouldHaveIcons(int number) {
        homePage.checkIfIconsExist(number);
    }

    @And("^Home Page should have '(\\d+)' texts under icons$")
    public void interfaceShouldHaveTextUnderIcons(int number) {
        homePage.checkIfTextsUnderIconsExist(number);
    }

    @And("^Home Page should have headline and description$")
    public void interfaceShouldHaveHeadlineAndDescription() {
        homePage.checkIfHeadlineAndDescriptionExist();
    }

    @When("^I click on Service subcategory in the header$")
    public void iOpenServiceMenuInHeader(){
        homePage.openServiceMenuInHeader();
    }

    @Then("^Service dropdown menu in header displays following options$")
    public void headerServiceShouldHaveOptions(List<ServiceSubmenu> options) {
        homePage.checkServiceHeaderOptions(options);
    }

    @When("^I click on Service subcategory in the left section$")
    public void iOpenServiceMenuInLeftSection(){
        homePage.openServiceMenuInLeftSection();
    }

    @Then("^Service dropdown in left section displays following options$")
    public void leftSideServiceShouldHaveOptions(List<ServiceSubmenu> options){
        homePage.checkServiceLeftSideOptions(options);
    }

    @When("^I open header menu Service -> '([^\"]*)' Page$")
    public void iOpenDifferentElementsPage(ServiceSubmenu menuItem){
        homePage.openDifferentElementsPage(menuItem);
    }
}
