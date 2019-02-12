package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.ColorDropdownText;
import Homework.hw6.ex1.Enums.NatureElements;
import Homework.hw6.ex1.Enums.RadioButtonMetals;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {
    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "label[class='label-checkbox']")
    private ElementsCollection checkboxLabels;

    @FindBy(css = "input[type='radio']")
    private ElementsCollection radiobuttons;

    @FindBy(css = "label[class='label-radio']")
    private ElementsCollection radiobuttonLabels;

    @FindBy(css = "select[class='uui-form-element']")
    private SelenideElement colorChoiceDropdown;

    @FindBy(css = "select[class='uui-form-element'] > option")
    private ElementsCollection colors;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private ElementsCollection log;

    @FindBy(css = "select.uui-form-element > option:nth-child(4)")
    private ElementsCollection yellow;

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

    public void checkButtonsExist(int number){
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

    public void selectNatureElements(List<NatureElements> elements) {
        for (NatureElements element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldBe(checked);
        }
    }

    public void selectMetalRadiobutton(RadioButtonMetals expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        radiobuttons.get(expectedText.ordinal()).shouldBe(checked);
    }

    public void checkLogForRadioButton(RadioButtonMetals expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        log.get(0).shouldHave(text(expectedText.toString()));
    }

    public void selectColorDropdown(ColorDropdownText expectedColor) {
        colorChoiceDropdown.click();
        colors.get(expectedColor.ordinal()).click();
        colors.get(expectedColor.ordinal()).shouldBe(checked);
    }

    public void checkLogForColors(ColorDropdownText expectedColor) {
        log.get(0).shouldHave(text(expectedColor.toString()));
    }

    public void unselectNatureElements(List<NatureElements> elements) {
        for (NatureElements element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void makeSureNatureElementsAreUnselected(List<NatureElements> elements){
        for (NatureElements element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString()));
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void checkLogForNatureElements(NatureElements element, boolean isSelected) {
        log.findBy(text(element.toString())).shouldHave(text(": condition changed to " + isSelected));
    }
}
