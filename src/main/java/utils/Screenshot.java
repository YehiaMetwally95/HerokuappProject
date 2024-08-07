package utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    WebDriver driver;
    int SuccessCodeForTestNG =1;
    int FailureCodeForTestNG =2;

    public Screenshot(WebDriver driver)
    {
        this.driver = driver;
    }

    public void captureSuccess(int TestNGResult , String fileName) throws IOException {
        //Increment ScreenshotFileNumber
        if (TestNGResult ==SuccessCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForSuccess/"+ fileName +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(fileName,new ByteArrayInputStream(screenshot));
        }
    }

    public void captureFailure(int TestNGResult , String fileName) throws IOException {
        if (TestNGResult == FailureCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForFailure/"+ fileName +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(fileName,new ByteArrayInputStream(screenshot));
        }
    }

    public void captureSuccess(Scenario cucumberResult) throws IOException {
        //Increment ScreenshotFileNumber
        if (!cucumberResult.isFailed()) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForSuccess/"+cucumberResult.getName()+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(cucumberResult.getName(),new ByteArrayInputStream(screenshot));
        }
    }

    public void captureFailure(Scenario cucumberResult) throws IOException {
        if (cucumberResult.isFailed()) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/ScreenshotsForFailure/"+cucumberResult.getName()+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(cucumberResult.getName(),new ByteArrayInputStream(screenshot));
        }
    }

}
