package Homework.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
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

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String name, String psw) {
        profileButton.click();
        login.sendKeys(name);
        //user.password:
        password.sendKeys(psw);
        submit.click();

    }

    public WebElement getUserName(){
        return userName;
    }

// TODO Basically, comments like this should not be in repo.
// TODO But this idea is OK, take a look on  HomePage(WebDriver driver) {...} constructor
// TODO and how it works within PageFactory, there is one tricky thing...
//    public void open(){
//        driver.get("https://www.epam.com/");
//    }
}
