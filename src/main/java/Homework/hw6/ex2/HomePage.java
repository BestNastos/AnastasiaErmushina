package Homework.hw6.ex2;

import Homework.hw6.ex2.Enums.WebUser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "ul[class='dropdown-menu'] > li")
    private ElementsCollection headerServiceOptions;

    public void login(WebUser user) {
        profileButton.click();
        loginBox.sendKeys(user.login);
        passwordBox.sendKeys(user.password);
        submitButton.click();
    }

    public void openServiceMenu(){
        headerService.click();
    }

    public void openUserTablePage() {
        headerServiceOptions.get(4).click();
    }
}
