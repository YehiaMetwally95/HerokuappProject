package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

    WebDriver driver;

    public Screenshot(WebDriver driver)
    {
        this.driver = driver;
    }

    public void captureActualResult()
    {
        var screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }

    public void captureFailure()
    {
        var screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
}
