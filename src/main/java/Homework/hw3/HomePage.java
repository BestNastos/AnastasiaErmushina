package Homework.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Homework.hw3.NavigationItems.*;
import static Homework.hw3.Benefits.*;
import static Homework.hw3.HomePageData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement loginBox;

    @FindBy(css = "[id='password']")
    private WebElement passwordBox;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement usernameElement;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[id='epam_logo']")
    private WebElement logo;

    @FindBy(css = "[class~='m-l8'] > li")
    private List<WebElement> navigationItems;

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = "span[class='benefit-txt']")
    private List<WebElement> textsUnderBenefitImages;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement mainHeader1;

    @FindBy(css = "p.main-txt.text-center")
    private WebElement mainHeader2;

    @FindBy(css = "a[ui='link']")
    private WebElement subHeader;

    @FindBy(css = "div[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "div[class='footer-bg']")
    private WebElement footer;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(HomePageData url){
        driver.get(url.toString());
    }

    public void checkTitle(HomePageData title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void login(Users user) {
        profileButton.click();
        loginBox.sendKeys(user.login);
        passwordBox.sendKeys(user.password);
        submitButton.click();
    }

    public void checkIfUsernameIsCorrect(Users user) {
        assertEquals(usernameElement.getText(), user.name);
    }

    public void checkNavigationItems() {

        assertEquals(navigationItems.size(), 4);
        for (WebElement item : navigationItems) {
            assertTrue(item.isDisplayed());
        }

        assertEquals(navigationItems.get(0).getText(), HOME.toString());
        assertEquals(navigationItems.get(1).getText(), CONTACT.toString());
        assertEquals(navigationItems.get(2).getText(), SERVICE.toString());
        assertEquals(navigationItems.get(3).getText(), METALS.toString());
    }

    public void checkFourBenefitImagesDisplayed() {
        assertEquals(benefitIcons.size(), 4);
        for (WebElement benefitIcon : benefitIcons) {
            assertTrue(benefitIcon.isDisplayed());
        }
    }

    public void checkFourTextsUnderBenefitImages() {
        assertEquals(textsUnderBenefitImages.size(), 4);
        assertEquals(textsUnderBenefitImages.get(0).getText(), PRACTISE.toString());
        assertEquals(textsUnderBenefitImages.get(1).getText(), CUSTOM.toString());
        assertEquals(textsUnderBenefitImages.get(2).getText(), MULTI.toString());
        assertEquals(textsUnderBenefitImages.get(3).getText(), BASE.toString());
    }

    public void checkTextOfMainHeaders() {
        assertEquals(mainHeader1.getText(), MAIN_HEADER1.toString());
        assertEquals(mainHeader2.getText(), MAIN_HEADER2.toString());
    }

    public void checkIframeIsDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkLogoInIframeIsDisplayed() {
        driver = driver.switchTo().frame(iframe);
        assertTrue(logo.isDisplayed());
    }

    public void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    public void checkTextOfSubheader() {
        assertEquals(subHeader.getText(), SUBHEADER.toString());
    }

    public void checkJDIGithubLink() {
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), SUBHEADER_LINK.toString());
    }

    public void checkLeftSectionExists() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterExists() {
        assertTrue(footer.isDisplayed());
    }
}
