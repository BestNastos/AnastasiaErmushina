package Homework.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class websiteDisplaySoftAssertTest {

    SoftAssert softAssert;
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    // 17 Close Browser
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void websiteDisplayTest() {

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("[id='user-name']"));
        softAssert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationBar = driver.findElements(By
                .cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8"));
        List<WebElement> elements = navigationBar.get(0).findElements(By.xpath("*"));
        softAssert.assertEquals(elements.size(), 4);
        for (WebElement element : elements) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(elements.get(0).getText(), "HOME");
        softAssert.assertEquals(elements.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(elements.get(2).getText(), "SERVICE");
        softAssert.assertEquals(elements.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(benefitIcons.size(), 4);
        for (WebElement benefitIcon : benefitIcons) {
            softAssert.assertTrue(benefitIcon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textUnderIcons = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(textUnderIcons.size(), 4);
        softAssert.assertEquals(textUnderIcons.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(textUnderIcons.get(1).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(textUnderIcons.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(textUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        WebElement mainHeader1 = driver.findElement(By.name("main-title"));
        softAssert.assertEquals(mainHeader1.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainHeader2 = driver.findElement(By.name("jdi-text"));
        softAssert.assertEquals(mainHeader2.getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT " +
                "ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.cssSelector("[id='iframe']"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver = driver.switchTo().frame(iframe);
        WebElement logo = driver.findElement(By.cssSelector("#epam_logo"));
        softAssert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("body > div > " +
                "div.uui-main-container > main > div.main-content > h3:nth-child(3) > a"));
        softAssert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(subHeader.getTagName(), "a");
        softAssert.assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.className("sidebar-menu"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        softAssert.assertTrue(footer.isDisplayed());

        softAssert.assertAll();
    }
}
