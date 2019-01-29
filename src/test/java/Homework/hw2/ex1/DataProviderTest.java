package Homework.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class DataProviderTest {

    @DataProvider(parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {"practise", "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {"custom", "To be flexible and\n" +
                        "customizable"},
                {"multi", "To be multiplatform"},
                {"base", "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void iconTextTest(String selector, String expectedText) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        WebElement actualText = driver.findElement(By.className("icon-" + selector))
                .findElement(By.xpath("../.."))
                .findElement(By.cssSelector("[class='benefit-txt']"));

        assertEquals(actualText.getText(), expectedText);

        driver.close();
    }
}
