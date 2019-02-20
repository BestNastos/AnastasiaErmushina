package Homework.hw7.pages;

import Homework.hw7.Users;
import Homework.hw7.forms.SignInForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    SignInForm signInForm;

    @FindBy(css = "[id='user-icon']")
    private Icon profileButton;

    public void login(Users users) {
        profileButton.click();
        signInForm.login(users);
    }
}
