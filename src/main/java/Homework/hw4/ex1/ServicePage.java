package Homework.hw4.ex1;

import Homework.hw4.ex1.Enums.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class ServicePage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement profileButton;

    @FindBy(css = "[id='name']")
    private SelenideElement loginBox;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordBox;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement usernameElement;

    @FindBy(css = "li[class='dropdown']")
    private SelenideElement headerService;

    @FindBy(css = "ul[class='dropdown-menu'] > li")
    private ElementsCollection headerServiceOptions;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement leftSideService;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection leftSideServiceOptions;

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

    public void checkTitle(HomePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void login(WebUser user) {
        profileButton.click();
        loginBox.sendKeys(user.login);
        passwordBox.sendKeys(user.password);
        submitButton.click();
    }

    public void checkIfUsernameIsCorrect(WebUser user) {
        usernameElement.shouldHave(text(user.name));
    }

    public void checkServiceHeaderOptions(ServiceSubmenu[] dropdownElements) {
        headerService.click();
        for (int i = 0; i < dropdownElements.length; i++) {
            headerServiceOptions.get(i).exists();
            headerServiceOptions.get(i).shouldHave(text(dropdownElements[i].toString()));
        }
    }

    public void checkServiceLeftSectionOptions(ServiceSubmenu[] dropdownElements) {
        leftSideService.click();
        for (int i = 0; i < dropdownElements.length; i++) {
            leftSideServiceOptions.get(i).exists();
            leftSideServiceOptions.get(i).shouldHave(text(dropdownElements[i].toString()));
        }
    }

    public void openDifferentElementsPage() {
        headerService.click();
        headerServiceOptions.get(6).click();
    }

    public void checkDifferentElementsPageInterface() {
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

    public void selectCheckboxes(CheckBoxText water, CheckBoxText wind) {
        checkboxLabels.get(water.ordinal()).shouldHave(text(water.toString())).click();
        checkboxes.get(water.ordinal()).shouldBe(checked);
        checkboxLabels.get(wind.ordinal()).shouldHave(text(wind.toString())).click();
        checkboxes.get(wind.ordinal()).shouldBe(checked);
    }

    public void checkLogForCheckboxes(CheckBoxText water, CheckBoxText wind) {
        log.get(0).shouldHave(text(wind.toString()));
        log.get(0).shouldHave(text("true"));
        log.get(1).shouldHave(text(water.toString()));
        log.get(1).shouldHave(text("true"));
    }

    public void selectRadiobutton(RadioButtonText expectedText) {
        radiobuttonLabels.get(expectedText.ordinal()).shouldHave(text(expectedText.toString())).click();
        radiobuttons.get(expectedText.ordinal()).shouldBe(checked);
    }

    public void checkLogForRadioButton(RadioButtonText expectedText) {
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

    public void uncheckBoxes(CheckBoxText water, CheckBoxText wind) {
        checkboxLabels.get(water.ordinal()).shouldHave(text(water.toString())).click();
        checkboxes.get(water.ordinal()).shouldNotBe(checked);

        checkboxLabels.get(wind.ordinal()).shouldHave(text(wind.toString())).click();
        checkboxes.get(wind.ordinal()).shouldNotBe(checked);
    }

    public void checkLogForAllBoxes(CheckBoxText[] expectedText) {
        for (int i = 0; i < expectedText.length; i++) {
            checkboxLabels.get(i).shouldHave(text(expectedText[i].toString())).click();
            log.get(0).shouldHave(text(expectedText[i].toString()));
            if (checkboxes.get(i).isSelected()) {
                log.get(0).shouldHave(text("true"));
            } else {
                log.get(0).shouldHave(text("false"));
            }
        }
    }
}
