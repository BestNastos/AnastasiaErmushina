package Homework.hw4.ex1;

import Homework.hw4.ex1.Enums.HomePageInfo;
import Homework.hw4.ex1.Enums.ServiceSubmenu;
import Homework.hw4.ex1.Enums.WebUser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.text;
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

    @FindBy(css = "ul[class='dropdown-menu'] > li")
    private ElementsCollection headerServiceOptions;

    @FindBy(css = "li[class='menu-title'] > a[ui='label']")
    private SelenideElement leftSideService;

    @FindBy(css = "ul[class='sub'] > li")
    private ElementsCollection leftSideServiceOptions;

    public void open(HomePageInfo url) {
        getWebDriver().get(url.toString());
    }

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
}
