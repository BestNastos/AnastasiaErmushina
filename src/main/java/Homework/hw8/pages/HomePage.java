package Homework.hw8.pages;

import Homework.hw8.forms.Header;
import Homework.hw8.utils.NavigationItems;
import Homework.hw8.utils.Users;
import com.epam.jdi.light.elements.composite.WebPage;

import static Homework.hw8.pages.EpamWebsite.metalsAndColorsPage;
import static org.testng.Assert.assertEquals;

public class HomePage extends WebPage {

    public Header header;

    public void login(Users user) {
        header.profileIcon.click();
        header.signInForm.loginAs(user);
        assertEquals(header.usernameDisplayed.getText(), user.fullName);
    }

    public void openMenuItem(NavigationItems item) {
        header.navigationBar.select(item.toString());
        metalsAndColorsPage.shouldBeOpened();
    }
}
