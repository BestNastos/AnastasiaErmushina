package Homework.hw5.ex1.hw4ex1WithAllureAnnotations;

import Homework.hw5.ex1.Listener;
import Homework.hw5.ex1.hw4ex1WithAllureAnnotations.Enums.ColorDropdownText;
import Homework.hw5.ex1.hw4ex1WithAllureAnnotations.Enums.NatureElements;
import Homework.hw5.ex1.hw4ex1WithAllureAnnotations.Enums.RadioButtonMetals;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.*;

@Listeners(Listener.class)
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

    @Step("Checking checkboxes, radiobuttons, dropdown and buttons")
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

    @Step("Checking if the right section is displayed")
    public void checkRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    @Step("Checking if the left section is displayed")
    public void checkLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    @Step("Selecting checkboxes with forces of nature")
    public void selectNatureElements(NatureElements water, NatureElements wind) {
        checkboxLabels.get(water.ordinal()).shouldHave(text(water.toString())).click();
        checkboxes.get(water.ordinal()).shouldBe(checked);
        checkboxLabels.get(wind.ordinal()).shouldHave(text(wind.toString())).click();
        checkboxes.get(wind.ordinal()).shouldBe(checked);
    }

    @Step("Selecting a radiobutton with metals")
    public void selectMetalRadiobutton(RadioButtonMetals expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        radiobuttons.get(expectedText.ordinal()).shouldBe(checked);
    }

    @Step("Checking if log works for radiobuttons with metals")
    public void checkLogForRadioButton(RadioButtonMetals expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        log.get(0).shouldHave(text(expectedText.toString()));
    }

    @Step("Selecting a color from the dropdown menu")
    public void selectColorDropdown(ColorDropdownText expectedColor) {
        colorChoiceDropdown.click();
        colors.get(expectedColor.ordinal()).click();
        colors.get(expectedColor.ordinal()).shouldBe(checked);
    }

    @Step("Checking if log works for color selection in dropdown menu")
    public void checkLogForColors(ColorDropdownText expectedColor) {
        log.get(0).shouldHave(text(expectedColor.toString()));
    }

    @Step("Unselecting checkboxes with forces of nature")
    public void unselectNatureElements(NatureElements... elements) {
        for (NatureElements element : elements) {
            checkboxLabels.get(element.ordinal()).shouldHave(text(element.toString())).click();
            checkboxes.get(element.ordinal()).shouldNotBe(checked);
        }
    }

    @Step("Checking if log works for checkboxes with forces of nature")
    public void checkLogForAllNatureElements(NatureElements element, boolean isSelected) {
        log.findBy(text(element.toString())).shouldHave(text(": condition changed to " + isSelected));
    }
}
