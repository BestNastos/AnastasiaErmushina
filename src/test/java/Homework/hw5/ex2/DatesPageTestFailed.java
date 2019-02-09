package Homework.hw5.ex2;

import Homework.hw5.ex1.DatesPageWithAllureAnnotations.DatesPage;
import Homework.hw5.ex1.DatesPageWithAllureAnnotations.HomePage;
import Homework.hw5.ex1.DatesPageWithAllureAnnotations.SelenideBaseHomework;
import Homework.hw5.ex1.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums.HomePageInfo.HOME_PAGE_TITLE;
import static Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums.HomePageInfo.URL;
import static Homework.hw5.ex1.DatesPageWithAllureAnnotations.Enums.WebUser.PITER;
import static com.codeborne.selenide.Selenide.*;

@Listeners(Listener.class)
@Feature("Proper UI display")
public class DatesPageTestFailed extends SelenideBaseHomework {
    private DatesPage datesPage;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(URL.toString());
        datesPage = page(DatesPage.class);
        homePage = page(HomePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Story("Dates Page Story (Failed)")
    @Test
    public void datesPageTestFailed() {
        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkIfUsernameIsCorrect(PITER);

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesPage();

        //6 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(0, 7);

        //8 Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most left position.
        datesPage.setRange(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(0, 0);

        //10 Using drag-and-drop set Range sliders.
        // left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setRange(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setRange(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogForSliders(30, 70);
    }
}
