package Homework.hw6.ex1;

import Homework.hw6.ex1.Enums.HomePageInfo;
import Homework.hw6.ex1.Enums.ServiceSubmenu;
import Homework.hw6.ex1.Enums.WebUser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePage {

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

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection headerServiceOptions;

    @FindBy(css = "li.menu-title > a[ui='label']")
    private SelenideElement leftSideService;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection leftSideServiceOptions;

    @FindBy(css = "div.benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(css = "span.benefit-txt")
    private ElementsCollection textsUnderBenefitImages;

    @FindBy(css = "h3.main-title.text-center")
    private SelenideElement headline;

    @FindBy(css = "p.main-txt.text-center")
    private SelenideElement description;

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

    public void checkServiceHeaderOptions(List<ServiceSubmenu> dropdownElements) {
        for (int i = 0; i < dropdownElements.size(); i++) {
            headerServiceOptions.get(i).exists();
            headerServiceOptions.get(i).shouldHave(text(dropdownElements.get(i).toString()));
        }
    }

    public void checkServiceLeftSideOptions(List<ServiceSubmenu> dropdownElements) {
        for (int i = 0; i < dropdownElements.size(); i++) {
            leftSideServiceOptions.get(i).exists();
            leftSideServiceOptions.get(i).shouldHave(text(dropdownElements.get(i).toString()));
        }
    }

    public void openDifferentElementsPage(ServiceSubmenu menuItem) {
        headerService.click();
        headerServiceOptions.findBy(text(menuItem.toString())).click();
    }

    public void checkIfIconsExist(int number) {
        for (SelenideElement benefitIcon : benefitIcons) {
            benefitIcon.should(exist);
            benefitIcons.shouldHaveSize(number);
        }
    }

    public void checkIfTextsUnderIconsExist(int number) {
        for (SelenideElement textsUnderBenefitImage : textsUnderBenefitImages) {
            textsUnderBenefitImage.should(exist);
        }
        textsUnderBenefitImages.shouldHaveSize(number);
    }

    public void checkIfHeadlineAndDescriptionExist() {
        headline.should(exist);
        description.should(exist);
    }

    public void openServiceMenuInHeader() {
        headerService.click();
    }

    public void openServiceMenuInLeftSection() {
        leftSideService.click();
    }
}
