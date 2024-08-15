package baseTest;

import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

import java.io.File;
import java.io.IOException;

import static utils.BrowserOptions.openBrowser;
import static utils.CookiesManager.*;
import static utils.Screenshot.*;
import static utils.WindowManager.*;
import static utils.ThreadDriver.*;
import static utils.DeleteDirectoryFiles.*;
import static utils.PropertiesFileManager.*;

public class BaseTest {

    //Variables
    public WebDriver driver;
    public ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();;

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
    //@Parameters({"BrowserType"})
    public void setUpAndOpenBrowser()
    {
        //Open Browser
        driver = openBrowser();

        //Generate Isolated Driver from ThreadDriver
        setIsolatedDriver(threadDriver,driver);

        //Perform actions on Window
        navigateToURL(getIsolatedDriver(threadDriver), getPropertiesValue("baseUrl"));
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

        //Remove the Isolated Driver from Memory
        removeIsolatedDriver(threadDriver);
    }
}
