package JDI;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExampleJDI {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(EpamSite.class);

    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void simpleJDItest() {
        EpamSite.homePageJDI.open();
        EpamSite.homePageJDI.login(User.PITER);
    }
}
