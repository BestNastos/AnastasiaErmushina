package JDI;

import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import cucumber.api.java.After;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExampleJDI {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(EpamSite.class);
//        WebSettings.SEARCH_CONDITION = e -> {return e.isDisplayed();};
//        ActionHelper.BEFORE_JDI_ACTION = jp ->{};
//        ActionHelper.AFTER_JDI_ACTION = (jp, o) ->{
//            return ActionHelper.AFTER_STEP_ACTION;
//        }; // check if correct (teacher's repository)

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
