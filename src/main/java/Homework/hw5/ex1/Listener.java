package Homework.hw5.ex1;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Listener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] printScreen() {
        System.out.println("printScreen method started");
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            System.out.println("printScreen method WebDriverException");

            e.printStackTrace();
        }
        System.out.println("printScreen method ended");

        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        printScreen();
    }

//    @Override
//    public void onTestSuccess(ITestResult tr) {
//        makeScreenshot();
//    }
}