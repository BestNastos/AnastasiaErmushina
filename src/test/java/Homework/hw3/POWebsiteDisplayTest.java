package Homework.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POWebsiteDisplayTest {

    private WebDriver webDriver;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.manage().window().maximize();
    }

    // 17 Close Browser
    @AfterMethod
    public void afterMethod() {
        webDriver.close();
    }

    @Test
    public void simpleTest() {

        //1 Open test site by URL
        // TODO All f this enum calls can be simplified by static import
        homePage.open(HomePageData.URL);

        //2 Assert Browser title
        homePage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //3 Perform login
        homePage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkIfUsernameIsCorrect(Users.PITER);

        //5 Assert Browser title
        homePage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNavigationItems();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkFourBenefitImagesDisplayed();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkFourTextsUnderBenefitImages();

        //9 Assert a text of the main headers
        homePage.checkTextOfMainHeaders();

        //10 Assert that there is the iframe in the center of page
        homePage.checkIframeIsDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.checkLogoInIframeIsDisplayed();

        //12 Switch to original window back
        homePage.switchToMainFrame();

        //13 Assert a text of the sub header
        homePage.checkTextOfSubheader();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDIGithubLink();

        //15 Assert that there is Left Section
        homePage.checkLeftSectionExists();

        //16 Assert that there is Footer
        homePage.checkFooterExists();
    }
}
