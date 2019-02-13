package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.Color;
import Homework.hw6.ex1.Enums.ForceOfNature;
import Homework.hw6.ex1.Enums.Metal;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {
    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxLabels;

    @FindBy(css = "input[type='radio']")
    private ElementsCollection radiobuttons;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radiobuttonLabels;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement colorChoiceDropdown;

    @FindBy(css = "select.uui-form-element > option")
    private ElementsCollection colors;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private ElementsCollection log;

    public void checkCheckboxesWithNatureElements(int number) {
        for (SelenideElement checkbox : checkboxes) {
            checkbox.should(exist);
        }
        checkboxes.shouldHaveSize(number);
    }

    public void checkRadioButtonsWithMetal(int number) {
        for (SelenideElement radiobutton : radiobuttons) {
            radiobutton.should(exist);
        }
        radiobuttons.shouldHaveSize(number);
    }

    public void checkColorChoiceDropdown() {
        colorChoiceDropdown.should(exist);
    }

    public void checkButtonsExist(int number) {
        for (SelenideElement button : buttons) {
            button.should(exist);
        }
        buttons.shouldHaveSize(number);
    }

    public void checkRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    public void selectForceOfNature(List<ForceOfNature> elements) {
        for (ForceOfNature element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldBe(checked);
        }
    }

    public void selectMetalRadiobutton(Metal expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        radiobuttons.get(expectedText.ordinal()).shouldBe(checked);
    }

    public void checkLogForRadioButton(Metal expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        log.get(0).shouldHave(text(expectedText.toString()));
    }

    public void selectColorDropdown(Color expectedColor) {
        colorChoiceDropdown.click();
        colors.get(expectedColor.ordinal()).click();
        colors.get(expectedColor.ordinal()).shouldBe(checked);
    }

    public void checkLogForColors(Color expectedColor) {
        log.get(0).shouldHave(text(expectedColor.toString()));
    }

    public void unselectForcesOfNature(List<ForceOfNature> elements) {
        for (ForceOfNature element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void assertForcesOfNatureAreUnselected(List<ForceOfNature> elements) {
        for (ForceOfNature element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString()));
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void checkLogForForcesOfNature(DataTable table) {
        List<List<String>> data = table.raw();
        for (int i = 0; i < data.size(); i++) {
            log.findBy(text(data.get(i).get(0))).shouldHave(text(data.get(i).get(1)));
        }
    }
}
