package Homework.hw4.ex2;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = "div[aria-disabled='false'] > a")
    private ElementsCollection handles;

    @FindBy(css = "div.col-sm-5 > div.ui-corner-all")
    private SelenideElement slider;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private ElementsCollection log;

    public void setRange1(int from, int to) {
        double width = slider.getSize().getWidth();
        double percent = width / 100.0;
        setHandleHelper(0, -(int) width);
        setHandleHelper(1, (int) width);
        double offset;
        if (from == 0) {
            offset = -percent;
        } else if (from == 30) {
            offset = percent * from - 1.5 * percent;
        } else if (from == 100) {
            offset = width;
        } else {
            throw new IllegalArgumentException();
        }
        setHandleHelper(0, (int) offset);
        if (to == 0) {
            offset = -width - percent;
        } else if (to == 70) {
            offset = percent * (to - 100) - percent;
        } else if (to == 100) {
            offset = percent;
        } else {
            throw new IllegalArgumentException();
        }
        setHandleHelper(1, (int) offset);
    }

    private void setHandleHelper(int handleNumber, int offset) {
        new Actions(getWebDriver())
                .clickAndHold(handles.get(handleNumber))
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    public void setRange2(int from, int to) {
        setHandleHelper(0, offsetCalculatorForSetRange2(0, from));
        setHandleHelper(1, offsetCalculatorForSetRange2(1, to));
    }

    private int offsetCalculatorForSetRange2(int elementIndex, int targetValue) {
        int currentValue = Integer.valueOf(handles.get(elementIndex).innerText());
        int difference = targetValue - currentValue;
        return (int) (difference * slider.getSize().getWidth() / 100.0);
    }

    public void checkLogForSliders(int from, int to) {
        log.get(0).shouldHave(text("Range 2(To):" + to + " link clicked"));
        log.get(1).shouldHave(text("Range 2(From):" + from + " link clicked"));
    }
}
