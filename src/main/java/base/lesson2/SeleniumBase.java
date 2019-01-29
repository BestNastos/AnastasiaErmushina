package base.lesson2;

import org.testng.annotations.BeforeSuite;

public class SeleniumBase {

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }


}
