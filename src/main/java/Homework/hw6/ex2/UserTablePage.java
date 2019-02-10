package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.UserTablePageInfo;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class UserTablePage {

    @FindBy(css = "tr > td:first-child")
    private ElementsCollection numbers;

    @FindBy(css = "tr > td > select")
    private ElementsCollection typeDropdowns;

    @FindBy(css = "tr > td > a")
    private ElementsCollection usernames;

    @FindBy(css = "tr > td > img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "div.user-descr > span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private ElementsCollection vipCheckboxes;

    @FindBy(css = "table[id='user-table']")
    private SelenideElement userTable;

    public void checkTitle(UserTablePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

}
