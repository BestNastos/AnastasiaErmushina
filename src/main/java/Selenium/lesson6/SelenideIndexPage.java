package Selenium.lesson6;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SelenideIndexPage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement profileButton;

    @FindBy(css = "[id='name']")
    private SelenideElement login;

    @FindBy(css = "[id='password']")
    private SelenideElement password;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submit;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    public SelenideIndexPage(){
        page(this);
    }

    public void login(String name, String psw) {
        profileButton.click();
        login.sendKeys(name);
        //user.password:
        password.sendKeys(psw);
        submit.click();

    }

    public SelenideElement getUserName() {
        return userName;
    }
}
