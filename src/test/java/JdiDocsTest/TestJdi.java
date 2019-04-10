package JdiDocsTest;

import Homework.hw8.pages.EpamWebsite;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Homework.hw8.pages.EpamWebsite.homePage;
import static Homework.hw8.pages.Html5Page.birthDate;
import static Homework.hw8.utils.Defaults.PITER;
import static org.testng.Assert.assertEquals;

public class TestJdi {

    @BeforeMethod
    public void beforeSuite() {
        PageFactory.initElements(EpamWebsite.class);
        homePage.open();
    }

    @Test
    public void test() {

        homePage.login(PITER);

        homePage.openHtml5page();

        birthDate.setDateTime("2017-05-10");

        assertEquals(birthDate.value(), "2017-05-10");
    }

    @AfterMethod
    public void afterSuite() {
//        WebDriverFactory.close();
    }
}
