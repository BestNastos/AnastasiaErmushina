package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.Color;
import Homework.hw6.ex1.Enums.ForceOfNature;
import Homework.hw6.ex1.Enums.Metal;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageSteps {

    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);

    @Then("^Interface on Different elements page contains '(\\d+)' checkboxes with forces of nature$")
    public void interfaceShouldContainCheckboxes(int number) {
        diffElemPage.checkCheckboxesWithNatureElements(number);
    }

    @And("^Interface on Different elements page contains '(\\d+)' radio buttons with metals$")
    public void interfaceShouldContainRadioButtons(int number) {
        diffElemPage.checkRadioButtonsWithMetal(number);
    }

    @And("^Interface on Different elements page contains color choice dropdown$")
    public void interfaceShouldContainColorDropdown() {
        diffElemPage.checkColorChoiceDropdown();
    }

    @And("^Interface on Different elements page contains '(\\d+)' buttons$")
    public void interfaceShouldHaveButtons(int number) {
        diffElemPage.checkButtonsExist(number);
    }

    @And("^Different elements page has a Right section$")
    public void differentElementsPageShouldHaveRightSection() {
        diffElemPage.checkRightSectionDisplayed();
    }

    @And("^Different elements page has a Left section$")
    public void differentElementsPageShouldHaveLeftSection() {
        diffElemPage.checkLeftSectionDisplayed();
    }

    @When("^I select following checkboxes with forces of nature on Different elements page:$")
    public void iSelectForcesOfNature(List<ForceOfNature> elements) {
        diffElemPage.selectForceOfNature(elements);
    }

    @Then("^For each checkbox there is a log row with corresponding status$")
    public void logShouldWorkForForcesOfNature(DataTable elements) {
        diffElemPage.checkLogForForcesOfNature(elements);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void iSelectRadioButton(Metal metal) {
        diffElemPage.selectMetalRadiobutton(metal);
    }

    @Then("^There is a log raw for '([^\"]*)' radio button$")
    public void logShouldWorkForMetalButton(Metal metal) {
        diffElemPage.checkLogForRadioButton(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void iSelectColor(Color color) {
        diffElemPage.selectColorDropdown(color);
    }

    @Then("^There is a log raw for '([^\"]*)' color dropdown$")
    public void logShouldWorkForColors(Color color) {
        diffElemPage.checkLogForColors(color);
    }

    @When("^I unselect checkboxes:$")
    public void iUnselectForcesOfNature(List<ForceOfNature> elements) {
        diffElemPage.unselectForcesOfNature(elements);
    }

    @Then("^Following boxes are unchecked:$")
    public void natureElementsShouldBeUnselected(List<ForceOfNature> elements) {
        diffElemPage.assertForcesOfNatureAreUnselected(elements);
    }
}
