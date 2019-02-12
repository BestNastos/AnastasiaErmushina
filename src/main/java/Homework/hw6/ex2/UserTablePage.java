package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.TableUsername;
import Homework.hw6.ex2.Enums.UserTablePageInfo;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
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

    @FindBy(css = "ul.logs > li:first-child")
    private SelenideElement log;

    public void checkTitle(UserTablePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void checkUserTableContainsElements(DataTable dataTable){
        List<List<String>> table = dataTable.raw();
        for (int i = 0; i < table.size()-1 ; i++) {
            numbers.get(i).shouldHave(text(table.get(i + 1).get(0)));
            usernames.get(i).shouldHave(text(table.get(i + 1).get(1)));
//            descriptionTexts.get(i).shouldHave(matchesText(table.get(i + 1).get(2)));
        }
    }

    public void checkNumberTypeDropdowns(){
        for (int i = 0; i < numbers.size() ; i++) {
            numbers.get(i).shouldBe(visible);
            typeDropdowns.get(i).shouldBe(visible);
        }
    }

    public void checkUsernames(){
        for (SelenideElement username : usernames) {
            username.shouldBe(visible);
        }
    }

    public void checkDescriptionImages(){
        for (SelenideElement descriptionImage : descriptionImages) {
            descriptionImage.shouldBe(visible);
        }
    }

    public void checkTextsUnderImages(){
        for (SelenideElement descriptionText : descriptionTexts) {
            descriptionText.shouldBe(visible);
        }
    }

    public void checkVipCheckboxes(){
        for (SelenideElement vipCheckbox : vipCheckboxes) {
            vipCheckbox.shouldBe(visible);
        }
    }

    public void selectVipBox(TableUsername name){
        for (SelenideElement vip : vipCheckboxes) {
            if (name.toString().toLowerCase().contains(vip.getAttribute("id"))){
                vip.click();
            }
        }
    }

    public void checkLogForVipBox(String message){
        log.shouldHave(text(message));
    }

    public void openDropdownColumnTypeForUser(TableUsername name){
//     $x("//a[text()='" + name.toString() + "']/../../td/select");
        usernames.findBy(text(name.toString())).$x("../../td/select").click();
    }

    public void checkDropdownHasValues(List<String> values){
        ElementsCollection statuses = typeDropdowns.get(0).$$("option");
        for (int i = 0; i < values.size(); i++) {
            statuses.get(i).shouldHave(text(values.get(i)));
        }
    }
}
