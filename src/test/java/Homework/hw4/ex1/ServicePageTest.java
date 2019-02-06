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

public class ServicePageTest extends SelenideBaseHomework {
    ServicePage servicePage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(URL.toString());
        servicePage = page(ServicePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void servicePageTest() {
        //2 Assert Browser title
        servicePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        servicePage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkIfUsernameIsCorrect(PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkServiceHeaderOptions(ServiceSubmenu.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.checkServiceLeftSectionOptions(ServiceSubmenu.values());

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openDifferentElementsPage();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePage.checkDifferentElementsPageInterface();

        //9 Assert that there is Right Section
        servicePage.checkRightSectionDisplayed();

        //10 Assert that there is Left Section
        servicePage.checkLeftSectionDisplayed();

        //11 Select checkboxes
        servicePage.selectCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        servicePage.checkLogForCheckboxes(WATER, WIND);

        //13 Select radio
        servicePage.selectRadiobutton(SELEN);

        //14 Assert that for radiobutton there is a log row and
        // value is corresponded to the status of radiobutton.
        servicePage.checkLogForRadioButton(SELEN);

        //15 Select in dropdown
        servicePage.selectColorDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and
        // value is corresponded to the selected value.
        servicePage.checkLogForColors(YELLOW);

        //17 Unselect and assert checkboxes
        servicePage.uncheckBoxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and
        // value is corresponded to the status of checkbox.
        servicePage.checkLogForAllBoxes(CheckBoxText.values());
    }
}
