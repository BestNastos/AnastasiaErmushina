package Homework.hw7.pages;

import Homework.hw7.NavigationItems;
import Homework.hw7.Users;
import Homework.hw7.forms.Header;
import Homework.hw7.forms.SignInForm;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Icon;
import org.testng.Assert;

import static Homework.hw7.NavigationItems.*;
import static Homework.hw7.pages.JdiSite.metalsAndColorsPage;

public class HomePage extends WebPage {

    public SignInForm signInForm;

//    @FindBy(css = "[class~='m-l8']") //TODO goes there where we init PO, video 10:11
    public Header header;

    @FindBy(css = "[id='user-icon']")
    private Icon profileButton;

    @FindBy(css = "[id='user-name']")
    private UIElement usernameElement;

    public void login(Users user) {
        profileButton.click();
        signInForm.login(user);
        Assert.assertEquals(usernameElement.getText(), user.toString());//TODO jdi analogy?
    }

    public void openMenuItem(NavigationItems item){ // TODO is it the right way?
        header.serviceMenu.select(item.toString());

    }
}
