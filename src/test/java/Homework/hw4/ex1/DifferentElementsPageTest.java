package Homework.hw4.ex1;

import Homework.hw4.ex1.Enums.CheckBoxText;
import Homework.hw4.ex1.Enums.ServiceSubmenu;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Homework.hw4.ex1.Enums.CheckBoxText.*;
import static Homework.hw4.ex1.Enums.ColorDropdownText.*;
import static Homework.hw4.ex1.Enums.HomePageInfo.*;
import static Homework.hw4.ex1.Enums.RadioButtonText.*;
import static Homework.hw4.ex1.Enums.WebUser.*;
import static com.codeborne.selenide.Selenide.*;

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

    @Test
    public void servicePageTest() {
        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkIfUsernameIsCorrect(PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceHeaderOptions(ServiceSubmenu.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceLeftSectionOptions(ServiceSubmenu.values());

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkInterface();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionDisplayed();

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogForCheckboxes(WATER, WIND);

        //13 Select radio
        differentElementsPage.selectRadiobutton(SELEN);

        //14 Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogForRadioButton(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectColorDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and
        // value is corresponded to the selected value.
        differentElementsPage.checkLogForColors(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.uncheckBoxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox.
        differentElementsPage.checkLogForAllBoxes(CheckBoxText.values());
    }
}
