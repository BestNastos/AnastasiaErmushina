package base.lesson4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelenideIndexPage {
    private SelenideIndexPage indexPage;
    WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    public SelenideIndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String name, String psw){
        profileButton.click();
        login.sendKeys(name);
        //user.password:
        password.sendKeys(psw);
        submit.click();

    }

    public WebElement getUserName(){
        return userName;
    }

    public void open(){
        driver.get("https://epam.github.io/JDI/index.html");
    }
}
