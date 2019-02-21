package Homework.hw7.forms;

import Homework.hw7.Users;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class SignInForm extends Form<Users> {

    @Css("[id='name']")
    private TextField login;

    @Css("[id='password']")
    private TextField password;

    @Css("[id='login-button']")
    public Button submit;//TODO private

    //login method not needed
}
