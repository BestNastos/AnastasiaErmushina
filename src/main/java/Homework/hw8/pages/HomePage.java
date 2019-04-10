package Homework.hw8.pages;

import Homework.hw8.forms.Header;
import Homework.hw8.utils.NavigationItems;
import Homework.hw8.utils.Users;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

import static Homework.hw8.pages.EpamWebsite.metalsAndColorsPage;
import static org.testng.Assert.assertEquals;

public class HomePage extends WebPage {

    public Header header;

    @Css("#mCSB_1_container > ul > li:nth-child(5) > a > span")
    public static WebElement elementsPacks;

    @Css("a[href='html5.html']")
    public static WebElement html5;

    public void login(Users user) {
        header.profileIcon.click();
        header.signInForm.loginAs(user);
        assertEquals(header.usernameDisplayed.getText(), user.fullName);
    }

    public void openMenuItem(NavigationItems item) {
        header.navigationBar.select(item.toString());
        metalsAndColorsPage.shouldBeOpened();
    }

    public void openHtml5page(){
        elementsPacks.click();
        html5.click();
    }
}
