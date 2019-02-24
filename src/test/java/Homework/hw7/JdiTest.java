package Homework.hw7;

import Homework.hw7.enums.DefaultFormData;
import Homework.hw7.pages.EpamWebsite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import static Homework.TRYmain.ContactFormPage.contactForm;
import static Homework.hw7.enums.Color.*;
import static Homework.hw7.enums.Metal.Selen;
import static Homework.hw7.enums.NavigationItems.*;
import static Homework.hw7.enums.Users.*;
import static Homework.hw7.pages.EpamWebsite.*;
import static Homework.hw7.pages.MetalsAndColorsPage.*;

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

//      1 Login on JDI site as User
        homePage.login(PITER);

//      2 Open Metals & Colors page by Header menu

        homePage.openMenuItem(METALS_COLORS);
        metalsAndColorsPage.shouldBeOpened();

//        homePage.openMenuItem(CONTACT);
//        contactForm.submit(DEFAULT_CONTACT);
//        MCform.submit(DEFAULT_MC);

//        3 Fill form Metals & Colors by data
        DefaultFormData data = new DefaultFormData();
        metalsAndColorsPage.fillForm(data);
    }
}
