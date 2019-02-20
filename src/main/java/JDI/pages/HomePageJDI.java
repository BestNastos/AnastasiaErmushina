package JDI.pages;

import JDI.User;
import JDI.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;

public class HomePageJDI extends WebPage {

    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon profileButton;

    public void login(User user) {
        profileButton.click();
        loginForm.login(user);
    }
}
