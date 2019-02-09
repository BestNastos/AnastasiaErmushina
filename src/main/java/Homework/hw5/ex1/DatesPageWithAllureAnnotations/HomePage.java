package Homework.hw5.ex1.DatesPageWithAllureAnnotations;

import Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums.HomePageInfo;
import Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums.WebUser;
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

    @Step("Clicking on 'Dates' from the header 'Service' dropdown menu")
    public void openDatesPage() {
        headerService.click();
        headerServiceOptions.get(1).click();
    }
}
