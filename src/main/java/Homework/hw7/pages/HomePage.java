package Homework.hw7.pages;

import Homework.hw7.NavigationItems;
import Homework.hw7.Users;
import Homework.hw7.forms.Header;
import Homework.hw7.forms.SignInForm;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Icon;
import org.testng.Assert;

import static org.testng.Assert.*;

public class HomePage extends WebPage {

    //    @FindBy(css = "[class~='m-l8']") //TODO goes where we init PO, video 10:11
    public Header header;

//    public SignInForm signInForm;

//    @Css("[id='user-icon']")
//    private Icon profileButton;
//
//    @Css("[id='user-name']")
//    private UIElement usernameElement;

    public void login(Users user) {
        header.profileIcon.click();
        header.signInForm.fill(user);
        header.signInForm.verify(user);
        header.signInForm.submit.click();
        assertEquals(header.usernameDisplayed.getText(), user.toString());//TODO jdi analogy?
    }

    public void openMenuItem(NavigationItems item){ // TODO is it the right way?
        header.navigationBar.select(item.toString());
    }
}
