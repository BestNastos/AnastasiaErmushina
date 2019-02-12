package Homework.hw6.ex1;

import Homework.hw6.ex1.DifferentElementsPage;
import Homework.hw6.ex1.Enums.*;
import Homework.hw6.ex1.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static Homework.hw6.ex1.Enums.NatureElements.*;
import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private HomePage homePage = page(HomePage.class);
    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBe(HomePageInfo browserTitle) {
        homePage.checkTitle(browserTitle);
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

    @Then("^Service dropdown menu in header displays following options$")
    public void headerServiceShouldHaveOptions(List<ServiceSubmenu> options) {
        homePage.checkServiceHeaderOptions(options);
    }

    @Then("^Service dropdown in left section displays following options$")
    public void leftSideServiceShouldHaveOptions(List<ServiceSubmenu> options){
        homePage.checkServiceLeftSideOptions(options);
    }

    @Then("^Interface on Different elements page contains '(\\d+)' checkboxes with nature elements$")
    public void interfaceShouldContainCheckboxes(int number){
        diffElemPage.checkCheckboxesWithNatureElements(number);
    }

    @And("^Interface on Different elements page contains '(\\d+)' radio buttons with metals$")
    public void interfaceShouldContainRadiobuttons(int number){
        diffElemPage.checkRadioButtonsWithMetal(number);
    }

    @And("^Interface on Different elements page contains color choice dropdown$")
    public void interfaceShouldContainColorDropdown(){
        diffElemPage.checkColorChoiceDropdown();
    }

    @And("^Interface on Different elements page contains '(\\d+)' buttons$")
    public void interfaceShouldHaveButtons(int number){
        diffElemPage.checkButtonsExist(number);
    }

    @And("^Different elements page has a Right section$")
    public void differentElementsPageShouldHaveRightSection(){
        diffElemPage.checkRightSectionDisplayed();
    }

    @And("^Different elements page has a Left section$")
    public void differentElementsPageShouldHaveLeftSection(){
        diffElemPage.checkLeftSectionDisplayed();
    }

    @Then("^For each checkbox there is a log row$")
    public void logShouldWorkForNatureElements(){
        diffElemPage.checkLogForNatureElements(WATER, true);
        diffElemPage.checkLogForNatureElements(WIND, true);
    }

    @Then("There is a log raw for '([^\"]*)' radio button")
    public void logShouldWorkForMetalButton(RadioButtonMetals metal){
        diffElemPage.checkLogForRadioButton(metal);
    }

    @Then("There is a log raw for '([^\"]*)' color dropdown")
    public void thereShouldBeLogrowForColors(ColorDropdownText color){
        diffElemPage.checkLogForColors(color);
    }

    @Then("Following boxes are unchecked:")
    public void natureElementsShouldBeUnselected(List<NatureElements> elements){
        diffElemPage.makeSureNatureElementsAreUnselected(elements);
    }
}
