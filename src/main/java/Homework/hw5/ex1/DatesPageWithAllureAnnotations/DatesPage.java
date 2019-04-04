package Homework.hw5.ex1.DatesPageWithAllureAnnotations;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = "div[aria-disabled='false'] > a")
    private ElementsCollection range2;

    @FindBy(css = "div[class='col-sm-5'] > div[class~='ui-corner-all']")
    private SelenideElement slider;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private ElementsCollection log;

    @Step("Setting range using slider handles to {0} and {1}")
    public void setRange(int from, int to) {
        double width = slider.getSize().getWidth();
        double percent = width / 100;
        setHandle(0, -(int) width);
        setHandle(1, (int) width);
        double offset;
        switch (from) {
            case 0:
                offset = -percent;
                break;
            case 30:
                offset = percent * from - 1.5 * percent;
                break;
            default:
                offset = width;
                break;
        }
        setHandle(0, (int) offset);
        switch (to) {
            case 0:
                offset = -width - percent;
                break;
            case 70:
                offset = percent * (to - 100) - percent;
                break;
            default:
                offset = percent;
                break;
        }
        setHandle(1, (int) offset);
    }

    private void setHandle(int handleNumber, int offset) {
        new Actions(getWebDriver())
                .clickAndHold(range2.get(handleNumber))
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    @Step("Checking if log shows correct data after setting slider handles to {0} and {1}")
    public void checkLogForSliders(int from, int to) {
        log.get(0).shouldHave(text("Range 2(To):" + to + " link clicked"));
        log.get(1).shouldHave(text("Range 2(From):" + from + " link clicked"));
    }
}
