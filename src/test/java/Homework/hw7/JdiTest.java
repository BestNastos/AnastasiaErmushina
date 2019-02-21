package Homework.hw7;

import Homework.hw7.pages.EpamWebsite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Homework.hw7.NavigationItems.*;
import static Homework.hw7.Users.*;
import static Homework.hw7.pages.EpamWebsite.*;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;

public class JdiTest {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(EpamWebsite.class);
        homePage.open();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void simpleJDItest() {

        //1 Login on JDI site as User
        homePage.login(PITER);


        //2 Open Metals & Colors page by Header menu
        homePage.openMenuItem(METALS_COLORS);
        metalsAndColorsPage.checkOpened(); //TODO move deeper

        //3 Fill form Metals & Colors by data


        //4 Submit form Metals & Colors


        //5 Result sections should contains data



    }
}
