package Homework.hw5.ex2;

import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.DifferentElementsPage;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.ServiceSubmenuLeft;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.ServiceSubmenuTop;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.HomePage;
import Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.SelenideBaseHomework;
import Homework.hw5.ex1.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.ColorDropdownText.YELLOW;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.HomePageInfo.HOME_PAGE_TITLE;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.NatureElements.WATER;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.NatureElements.WIND;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.RadioButtonMetals.SELEN;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.WebUser.PITER;
import static Homework.hw5.ex1.DiffElementsPageWithAllureAnnotations.Enums.HomePageInfo.URL;
import static com.codeborne.selenide.Selenide.*;

@Listeners(Listener.class)
@Feature("Proper UI display")
public class DifferentElementsPageTest extends SelenideBaseHomework {
    private DifferentElementsPage differentElementsPage;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(URL.toString());
        differentElementsPage = page(DifferentElementsPage.class);
        homePage = page(HomePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Story("Different Elements Page Story")
    @Test
    public void differentElementsPageTest() {
        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkIfUsernameIsCorrect(PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceHeaderOptions(ServiceSubmenuTop.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceLeftSectionOptions(ServiceSubmenuLeft.values());

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkInterface();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionDisplayed();

        //11 Select checkboxes
        differentElementsPage.selectNatureElements(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogForNatureElements(WATER, true);
        differentElementsPage.checkLogForNatureElements(WIND, true);

        //13 Select radio
        differentElementsPage.selectMetalRadiobutton(SELEN);

        //14 Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogForRadioButton(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectColorDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and
        // value is corresponded to the selected value.
        differentElementsPage.checkLogForColors(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.unselectNatureElements(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox.
        differentElementsPage.checkLogForNatureElements(WATER, false);
        differentElementsPage.checkLogForNatureElements(WIND, false);
    }
}
