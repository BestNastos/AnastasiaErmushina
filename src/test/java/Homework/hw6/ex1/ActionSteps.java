package Homework.hw6.ex1;

import Homework.hw6.ex1.DifferentElementsPage;
import Homework.hw6.ex1.Enums.*;
import Homework.hw6.ex1.HomePage;
import cucumber.api.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);
    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);

    @When("^I login as '([^\"]*)'$")
    public void iLoginAs(WebUser user){
        homePage.login(user);
    }

    @When("^I click on Service subcategory in the header$")
    public void iOpenServiceMenuInHeader(){
        homePage.openServiceMenuInHeader();
    }

    @When("^I click on Service subcategory in the left section$")
    public void iOpenServiceMenuInLeftSection(){
        homePage.openServiceMenuInLeftSection();
    }

    @When("^I open header menu Service -> '([^\"]*)' Page$")
    public void iOpenDifferentElementsPage(ServiceSubmenu menuItem){
        homePage.openDifferentElementsPage(menuItem);
    }

    @When("^I select following checkboxes on Different elements page:$")
    public void iSelectNatureElements(List<NatureElements> elements){
        diffElemPage.selectNatureElements(elements);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void iSelectRadioButton(RadioButtonMetals metal){
        diffElemPage.selectMetalRadiobutton(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void iSelectColor(ColorDropdownText color){
        diffElemPage.selectColorDropdown(color);
    }

    @When("^I unselect checkboxes:$")
    public void iUnselectNatureElements(List<NatureElements> elements){
        diffElemPage.unselectNatureElements(elements);
    }
}
