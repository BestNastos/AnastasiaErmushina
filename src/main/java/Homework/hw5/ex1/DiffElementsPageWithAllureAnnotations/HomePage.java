package Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations;

import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.HomePageInfo;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.ServiceSubmenu;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.WebUser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

//@Listeners(Listener.class)
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

    @FindBy(css = "ul[class='dropdown-menu'] > li")
    private ElementsCollection headerServiceOptions;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement leftSideService;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection leftSideServiceOptions;

    @Step("Checking if title of 'Home Page' is correct")
    public void checkTitle(HomePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    @Step("Logging in as 'PITER CHAILOVSKII'")
    public void login(WebUser user) {
        profileButton.click();
        loginBox.sendKeys(user.login);
        passwordBox.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Checking if username at the top right corner is correct after logging in")
    public void checkIfUsernameIsCorrect(WebUser user) {
        usernameElement.shouldHave(text(user.name));
    }

    @Step("Checking if 'Service' dropdown from the header contains options")
    public void checkServiceHeaderOptions(ServiceSubmenu[] dropdownElements) {
        headerService.click();
        for (int i = 0; i < dropdownElements.length; i++) {
            headerServiceOptions.get(i).exists();
            headerServiceOptions.get(i).shouldHave(text(dropdownElements[i].toString()));
        }
    }

    @Step("Checking if 'Service' dropdown from the left section contains options")
    public void checkServiceLeftSectionOptions(ServiceSubmenu[] dropdownElements) {
        leftSideService.click();
        for (int i = 0; i < dropdownElements.length; i++) {
            leftSideServiceOptions.get(i).exists();
            leftSideServiceOptions.get(i).shouldHave(text(dropdownElements[i].toString()));
        }
    }

    @Step("Clicking on 'Different Elements' from the header 'Service' dropdown menu")
    public void openDifferentElementsPage() {
        headerService.click();
        headerServiceOptions.get(6).click();
    }
}
