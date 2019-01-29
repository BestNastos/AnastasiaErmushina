package Homework.hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    public void login(String name, String psw){
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(psw);
        submit.click();

    }

//    public void open(){
//        driver.get("https://www.epam.com/");
//    }
}
