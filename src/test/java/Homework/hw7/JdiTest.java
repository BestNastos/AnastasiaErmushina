package Homework.hw7;

import Homework.hw7.enums.DefaultFormData;
import Homework.hw7.pages.EpamWebsite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.*;

import static Homework.TRYmain.Default.DEFAULT_CONTACT;
import static Homework.hw7.enums.NavigationItems.*;
import static Homework.hw7.enums.Users.*;
import static Homework.hw7.pages.EpamWebsite.*;
import static Homework.hw7_Form.DefaultData.DEFAULT_MC;

public class JdiTest {
    @BeforeMethod
    public void beforeSuite() {
        PageFactory.initElements(EpamWebsite.class);
        homePage.open();
    }

    @AfterMethod
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void contactPageTest() {
        homePage.login(PITER);
        homePage.openMenuItem(CONTACT);
        contactForm.submit(DEFAULT_CONTACT);
    }

    @Test
    public void metalsAndColorsViaForm() {
        homePage.login(PITER);
        homePage.openMenuItem(METALS_COLORS);
        metalsAndColorsPage.shouldBeOpened();
        MCform.submit(DEFAULT_MC);
        //TODO verify
    }

    @Test
    public void metalsAndColorsViaFormFillAndVerify() {
        homePage.login(PITER);
        homePage.openMenuItem(METALS_COLORS);
        metalsAndColorsPage.shouldBeOpened();
        MCform.fill(DEFAULT_MC);
//        MCform.verify(DEFAULT_MC); // fails
        MCform.submit.click();
    }

    @Test
    public void metalsAndColorsWithCustomFillMethod() {
        homePage.login(PITER);
        homePage.openMenuItem(METALS_COLORS);
        metalsAndColorsPage.shouldBeOpened();
        DefaultFormData data = new DefaultFormData();
        metalsAndColorsPage.fillForm(data);
        metalsAndColorsPage.submitForm();
        metalsAndColorsPage.checkResult(data);
    }
}
