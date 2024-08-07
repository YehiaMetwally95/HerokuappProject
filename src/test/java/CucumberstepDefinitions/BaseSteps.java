package CucumberstepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.BrowserOptions;
import utils.Screenshot;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseSteps {

    //Global or Shared Variables
    protected WebDriver driver;
    protected String url = "https://the-internet.herokuapp.com/";
    protected String Username;

    //Shared Methods
    protected WindowManager getWindowManager()
    {
        return new WindowManager(driver);
    }

    public Screenshot getScreenshot()
    {
        return new Screenshot(driver);
    }

    @Before()
    public void OpenBrowser()
    {
        //Open Browser before every Scenario
        driver= new ChromeDriver(BrowserOptions.getChromeOptions());
        //Perform actions on Window Manager
        getWindowManager().maximizeWindow();
    }

    @After()
    public void closeBrowser(Scenario scenario) throws IOException {
        //Take Screenshot after every successful test
        getScreenshot().captureSuccess(scenario);

        //Take Screenshot after every failed test
        getScreenshot().captureFailure(scenario);

        //Close Browser after every Scenario
        getWindowManager().closeCurrentWindow();
    }
}
