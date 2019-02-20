package JDI.lesson1.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageJDI extends WebPage {

    @FindBy(css = "[id='user-icon']")
    private Icon profileButton;

    @FindBy(css = "[id='name']")
    private TextField loginBox;

    @FindBy(css = "[id='password']")
    private TextField passwordBox;

    @FindBy(css = "[id='login-button']")
    private Button submitButton;

    public void login(String name, String password) {
        profileButton.click();
        loginBox.input(name);
        passwordBox.input(password);
        submitButton.click();
    }
}
