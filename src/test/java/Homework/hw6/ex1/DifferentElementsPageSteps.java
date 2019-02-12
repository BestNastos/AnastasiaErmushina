package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.ColorDropdownText;
import Homework.hw6.ex1.Enums.NatureElements;
import Homework.hw6.ex1.Enums.RadioButtonMetals;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static Homework.hw6.ex1.Enums.NatureElements.WATER;
import static Homework.hw6.ex1.Enums.NatureElements.WIND;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageSteps {

    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);

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

    @When("^I select following checkboxes on Different elements page:$")
    public void iSelectNatureElements(List<NatureElements> elements){
        diffElemPage.selectNatureElements(elements);
    }

    @Then("^For each checkbox there is a log row$")
    public void logShouldWorkForNatureElements(){
        diffElemPage.checkLogForNatureElements(WATER, true);
        diffElemPage.checkLogForNatureElements(WIND, true);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void iSelectRadioButton(RadioButtonMetals metal){
        diffElemPage.selectMetalRadiobutton(metal);
    }

    @Then("There is a log raw for '([^\"]*)' radio button")
    public void logShouldWorkForMetalButton(RadioButtonMetals metal){
        diffElemPage.checkLogForRadioButton(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void iSelectColor(ColorDropdownText color){
        diffElemPage.selectColorDropdown(color);
    }

    @Then("There is a log raw for '([^\"]*)' color dropdown")
    public void thereShouldBeLogrowForColors(ColorDropdownText color){
        diffElemPage.checkLogForColors(color);
    }

    @When("^I unselect checkboxes:$")
    public void iUnselectNatureElements(List<NatureElements> elements){
        diffElemPage.unselectNatureElements(elements);
    }

    @Then("Following boxes are unchecked:")
    public void natureElementsShouldBeUnselected(List<NatureElements> elements){
        diffElemPage.makeSureNatureElementsAreUnselected(elements);
    }
}
