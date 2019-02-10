package Homework.hw6.ex1.Steps;

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

    @Then("The browser title should be '([^\"]*)'")
    public void checkBrowserTitle(HomePageInfo browserTitle) {
        homePage.checkTitle(browserTitle);
    }

    @Then("^User's name should be '([^\"]*)'$")
    public void checkUsername(WebUser expectedName) {
        homePage.checkIfUsernameIsCorrect(expectedName);
    }

    @And("Interface should have all the necessary elements")
    public void checkInterface() {
        homePage.checkIfInterfaceIsProperlyDisplayed();
    }

    @Then("Service dropdown menu in header displays following options")
    public void checkServiceOptionsInHeader(List<ServiceSubmenu> options) {
        homePage.checkServiceHeaderOptions(options);
    }

    @Then("Service dropdown in left section displays following options")
    public void checkServiceOptionsInLeftSection(List<ServiceSubmenu> options){
        homePage.checkServiceLeftSectionOptions(options);
    }

    @Then("Interface on Different elements page contains all needed elements")
    public void interfaceShouldContainElements(){
        diffElemPage.checkInterface();
    }

    @And("There is a Right section")
    public void checkIfRightSectionIsThere(){
        diffElemPage.checkRightSectionDisplayed();
    }

    @And("There is a Left section")
    public void checkIfLeftSectionIsThere(){
        diffElemPage.checkLeftSectionDisplayed();
    }

    @Then("For each checkbox there is a log row")
    public void checkLogWorksForNatureElements(){
        diffElemPage.checkLogForNatureElements(WATER, true);
        diffElemPage.checkLogForNatureElements(WIND, true);
    }

    @Then("There is a log raw for '([^\"]*)' radio button")
    public void checkLogForMetalButton(RadioButtonMetals metal){
        diffElemPage.checkLogForRadioButton(metal);
    }

    @Then("There is a log raw for '([^\"]*)' color dropdown")
    public void checkLogForColors(ColorDropdownText color){
        diffElemPage.checkLogForColors(color);
    }

    @Then("Following boxes are unchecked:")
    public void assertNatureElementsAreUnselected(List<NatureElements> elements){
        diffElemPage.makeSureNatureElementsAreUnselected(elements);
    }
}
