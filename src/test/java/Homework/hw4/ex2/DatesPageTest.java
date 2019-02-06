package Homework.hw4.ex2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Homework.hw4.ex2.Enums.HomePageInfo.*;
import static Homework.hw4.ex2.Enums.SliderValue.*;
import static Homework.hw4.ex2.Enums.WebUser.*;
import static com.codeborne.selenide.Selenide.*;

public class DatesPageTest extends SelenideBaseHomework {
    private DatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(URL.toString());
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void datesPageTest() {
        //2 Assert Browser title
        datesPage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        datesPage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        datesPage.checkIfUsernameIsCorrect(PITER);

        //5 Open through the header menu Service -> Dates Page
        datesPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(ZERO, HUNDRED);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(ZERO, HUNDRED);

        //8 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most left position.
        datesPage.setRange(ZERO, ZERO);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(ZERO, ZERO);

        //10 Using drag-and-drop set Range sliders.
        // left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRange(HUNDRED, HUNDRED);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(HUNDRED, HUNDRED);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setRange(THIRTY, SEVENTY);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(THIRTY, SEVENTY);
    }
}
