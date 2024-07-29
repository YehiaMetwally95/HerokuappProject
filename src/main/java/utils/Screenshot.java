package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

    public void captureSuccess(int TestNGResult , String TestName) throws IOException {
        //Increment ScreenshotFileNumber
        if (TestNGResult ==SuccessCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/ScreenshotsForSuccess/"+TestName+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);
        }
    }

    public void captureFailure(int TestNGResult , String TestName) throws IOException {
        if (TestNGResult == FailureCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/ScreenshotsForFailure/"+TestName+".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);
        }
    }
}
