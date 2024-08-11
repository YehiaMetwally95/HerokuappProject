package utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    static int SuccessCodeForTestNG =1;
    static int FailureCodeForTestNG =2;

    public static void captureSuccess(WebDriver driver, ITestResult result) throws IOException {
        if (result.getStatus()==SuccessCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForSuccess/"+ result.getName() +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(result.getName(),new ByteArrayInputStream(screenshot));
        }
    }

    public static void captureFailure(WebDriver driver, ITestResult result) throws IOException {
        if (result.getStatus() == FailureCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForFailure/"+ result.getName() +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(result.getName(),new ByteArrayInputStream(screenshot));
        }
    }

    public static void captureSuccess(WebDriver driver, Scenario cucumberResult) throws IOException {
        //Increment ScreenshotFileNumber
        if (!cucumberResult.isFailed()) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForSuccess/"+cucumberResult.getName()+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(cucumberResult.getName(),new ByteArrayInputStream(screenshot));
        }
    }

    public static void captureFailure(WebDriver driver, Scenario cucumberResult) throws IOException {
        if (cucumberResult.isFailed()) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForFailure/"+cucumberResult.getName()+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(cucumberResult.getName(),new ByteArrayInputStream(screenshot));
        }
    }

}
