package Homework.hw7;

import Homework.hw7.pages.EpamWebsite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.*;

import static Homework.hw7.utils.Defaults.DEFAULT_DATA;
import static Homework.hw7.utils.Defaults.PITER;
import static Homework.hw7.utils.NavigationItems.*;
import static Homework.hw7.pages.EpamWebsite.*;

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
    public void metalsAndColorsWithCustomFillMethod() {

        // 1. Login on JDI site as User
        homePage.login(PITER);

        // 2. Open Metals & Colors page by Header menu
        homePage.openMenuItem(METALS_COLORS);

        // 3. Fill form Metals & Colors by data
        // Submit form Metals & Colors
        metalsAndColorsPage.metalsAndColorsForm.submit(DEFAULT_DATA);

        // 4. Result sections should contain data
        metalsAndColorsPage.checkResult(DEFAULT_DATA);
    }
}
