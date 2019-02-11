package Homework.hw4.ex1;

import Homework.hw4.ex1.Enums.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    public void checkInterface() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.should(exist);
        }
        radiobuttons.shouldHaveSize(4);
        for (SelenideElement radiobutton : radiobuttons) {
            radiobutton.should(exist);
        }
        colorChoiceDropdown.should(exist);
        buttons.shouldHaveSize(2);
        for (SelenideElement button : buttons) {
            button.should(exist);
        }
    }

    public void checkRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    public void selectNatureElements(NatureElements... elements) {
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

    public void unselectNatureElements(NatureElements... elements) {
        for (NatureElements element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    public void checkLogForNatureElements(NatureElements element, boolean isSelected) {
        log.findBy(text(element.toString())).shouldHave(text(": condition changed to " + isSelected));
    }
}
