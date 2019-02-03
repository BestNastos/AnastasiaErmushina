package base.lesson4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void login(String name, String psw) {
        profileButton.click();
        login.sendKeys(name);
        //user.password:
        password.sendKeys(psw);
        submit.click();

    }

    public WebElement getUserName() {
        return userName;
    }
}
