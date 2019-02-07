package Homework.hw4.ex2;

import Homework.hw4.ex2.Enums.HomePageInfo;
import Homework.hw4.ex2.Enums.WebUser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    public void openDatesPage() {
        headerService.click();
        headerServiceOptions.get(1).click();
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
}
