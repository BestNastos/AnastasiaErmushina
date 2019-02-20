package JDI.lesson1;

import JDI.lesson1.pages.HomePageJDI;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExampleJDI {

//    private HomePageJDI homePageJDI;
//    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
//        driver = new ChromeDriver();
//        driver.navigate().to("https://epam.github.io/JDI/index.html");
//        homePageJDI = PageFactory.initElements(driver, HomePageJDI.class);

        PageFactory.initElements(EpamSite.class);

    }

    @AfterSuite
    public void afterSuite() {
//        driver.close();
        WebDriverFactory.close();
    }

    @Test
    public void simpleJDItest() {
//        homePageJDI.login("epam", "1234");
        EpamSite.homePageJDI.open();
        EpamSite.homePageJDI.login("epam", "1234");
    }
}
