package Selenium.lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider {

    @DataProvider
    private Object[][] simpleDataProvider(){
        return new Object[][]{
                {7, "hello"},
                {9, "world"}

        };
    }


    @Test(dataProvider = "simpleDataProvider")
    public void simpleTest(int i, String str) {
        System.out.println("int = " + i + "\n" + "String = " +str);

    }
}
