package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.UserCredentials;
import Homework.hw6.ex2.Enums.UserTablePageInfo;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class HomePage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement profileButton;

    @FindBy(css = "[id='name']")
    private SelenideElement loginBox;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordBox;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "li[class='dropdown']")
    private SelenideElement headerService;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection headerServiceOptions;

    public void login(UserCredentials user) {
        profileButton.click();
        loginBox.sendKeys(user.login);
        passwordBox.sendKeys(user.password);
        submitButton.click();
    }

    public void openServiceMenu(){
        headerService.click();
    }

    public void openUserTablePage(UserTablePageInfo option) {
        headerServiceOptions.findBy(text(option.toString())).click();
    }
}
