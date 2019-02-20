package Selenium.lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(className = "user")
    private WebElement userField;

    @FindBy(className = "password")
    private WebElement passwordField;

    @FindBy(className = "submit")
    private WebElement submitButton;

    private WebDriver driver;

    public IndexPage(WebDriver driver){
      this.driver = driver;

    }

    public void login(String name, String password) {
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open(){
        driver.get("https://www.epam.com/");
    }
}
