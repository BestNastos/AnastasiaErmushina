package Homework.hw4.ex2;

import Homework.hw4.ex2.Enums.HomePageInfo;
import Homework.hw4.ex2.Enums.WebUser;
import Homework.hw4.ex2.Enums.SliderValue;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DatesPage {

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

    @FindBy(css = "div[class='range-from overflow'] > input")
    private ElementsCollection range1;

    @FindBy(css = "div[aria-disabled='false'] > a")
    private ElementsCollection range2;

    @FindBy(css = "div[class='col-sm-5'] > div[class~='ui-corner-all']")
    private SelenideElement slider;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private ElementsCollection log;

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

    public void openDatesPage() {
        headerService.click();
        headerServiceOptions.get(1).click();
    }

    public void setRange(SliderValue from, SliderValue to) {
        range1.get(0).sendKeys(from.toString());
        range1.get(1).sendKeys(to.toString());
        double width = slider.getSize().getWidth();
        double percent = width / 100;
        setHandle(0, -(int) width);
        setHandle(1, (int) width);
        double offset;
        switch (from.value) {
            case 0:
                offset = -percent;
                break;
            case 30:
                offset = percent * from.value - 1.5 * percent;
                break;
            default:
                offset = width;
                break;
        }
        setHandle(0, roundADouble(offset));
        switch (to.value) {
            case 0:
                offset = -width - percent;
                break;
            case 70:
                offset = percent * (to.value - 100) - percent;
                break;
            default:
                offset = percent;
                break;
        }
        setHandle(1, roundADouble(offset));
    }

    private void setHandle(int handleNumber, int offset) {
        new Actions(getWebDriver())
                .clickAndHold(range2.get(handleNumber))
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    private int roundADouble(double value) {
        if (value % (int) value < 0.5) return (int) value;
        else return (int) value + 1;
    }

    public void checkLogForSliders(SliderValue from, SliderValue to) {
        log.get(0).shouldHave(text("Range 2(To):" + to.toString() + " link clicked"));
        log.get(1).shouldHave(text("Range 2(From):" + from.toString() + " link clicked"));
        log.get(4).shouldHave(text("Range 1(To): value changed to " + to.toString()));
        log.get(5).shouldHave(text("Range 1(From): value changed to " + from.toString()));
        range1.get(0).clear();
        range1.get(1).clear();
    }
}
