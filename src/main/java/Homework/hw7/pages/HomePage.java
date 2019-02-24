package Homework.hw7.pages;

import Homework.hw7.enums.NavigationItems;
import Homework.hw7.enums.Users;
import Homework.hw7.forms.Header;
import com.epam.jdi.light.elements.composite.WebPage;

import static org.testng.Assert.*;

public class HomePage extends WebPage {

    public Header header;

    public void login(Users user) {
        header.profileIcon.click();
//        header.signInForm.fill(user);
//        header.signInForm.verify(user);
//        header.signInForm.submit.click();
        header.signInForm.loginAs(user);

        assertEquals(header.usernameDisplayed.getText(), user.toString());//TODO jdi analogy?
    }

    public void openMenuItem(NavigationItems item){ // TODO is it the right way?
        header.navigationBar.select(item.toString());
    }
}
