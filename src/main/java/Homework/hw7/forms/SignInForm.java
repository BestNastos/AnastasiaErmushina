package Homework.hw7.forms;

import Homework.hw7.Users;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class SignInForm extends Form<Users> {

    @FindBy(css = "[id='name']")
    private TextField login;

    @FindBy(css = "[id='password']")
    private TextField password;

    @FindBy(css = "[id='login-button']")
    private Button submit;



    //login method not needed
}
