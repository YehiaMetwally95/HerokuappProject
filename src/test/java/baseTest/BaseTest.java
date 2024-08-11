package baseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

import java.io.File;
import java.io.IOException;

import static utils.CookiesManager.*;
import static utils.Screenshot.*;
import static utils.WindowManager.*;
import static utils.ThreadDriver.*;
import static utils.DeleteDirectoryFiles.*;

public class BaseTest {

    //Variables
    public WebDriver driver;
    public ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();;
    public String url = "https://the-internet.herokuapp.com/";

    //Annotations

    @BeforeClass
    //Clear Old Files
    public void clearOldFiles() throws IOException {

        File file1 = new File("src/test/resources/Screenshots");
        File file2 = new File("allure-results");

        deleteFiles(file1);
        deleteFiles(file2);
    }

    @BeforeMethod
    @Parameters({"URL","BrowserType"})
    public void setUpAndOpenBrowser(String url , String browserType)
    {
        //Open Browser
        switch (browserType)
        {
            case "Chrome" :
                driver= new ChromeDriver(BrowserOptions.getChromeOptions());
                break;

            case "Firefox" :
                driver= new FirefoxDriver(BrowserOptions.getFireFoxOptions());
                break;

            case "Edge" :
                driver= new EdgeDriver(BrowserOptions.getEdgeOptions());
                break;
                default:
                    System.out.println("Wrong driver name");
        }

        //Generate Isolated Driver from ThreadDriver
        setIsolatedDriver(threadDriver,driver);

        //Perform actions on Window
        navigateToURL(getIsolatedDriver(threadDriver), url);
    }

    @AfterMethod
    public void getScreenshots(ITestResult result) throws IOException {

        //Take Screenshot after every successful test
        captureSuccess(getIsolatedDriver(threadDriver),result);

        //Take Screenshot after every failed test
        captureFailure(getIsolatedDriver(threadDriver), result);
    }

    @AfterMethod (dependsOnMethods = "getScreenshots")
    public void tearDownBrowser(){

        //Delete All Cookies
        deleteAllCookies(getIsolatedDriver(threadDriver));
        //Close Browser after every test
        closeCurrentWindow(getIsolatedDriver(threadDriver));

        removeIsolatedDriver(threadDriver);
    }
}
