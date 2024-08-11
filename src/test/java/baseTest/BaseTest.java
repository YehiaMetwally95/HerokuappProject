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

import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.JsonFileWriter.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

public class BaseTest {

    //Variables
    public WebDriver driver;
    public ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();;
    public String url = "https://the-internet.herokuapp.com/";

    //Annotations

    @BeforeClass
    //Clear Old Files
    public void clearOldFiles() throws IOException {

        File file = new File("src/test/resources/Screenshots/ScreenshotsForFailure");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }}

        file = new File("src/test/resources/Screenshots/ScreenshotsForSuccess");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }}

         file = new File("allure-results");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }}
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

        //Generate Isolated Driver from ThreadLocal
        threadDriver.set(driver);

        //Perform actions on Window Manager
        navigateToURL(threadDriver.get(), url);
    }

    @AfterMethod
    public void getScreenshots(ITestResult result) throws IOException {

        //Take Screenshot after every successful test
        captureSuccess(threadDriver.get(),result);

        //Take Screenshot after every failed test
        captureFailure(threadDriver.get(), result);
    }

    @AfterMethod (dependsOnMethods = "getScreenshots")
    public void tearDownBrowser(){

        //Delete All Cookies
        deleteAllCookies(threadDriver.get());
        //Close Browser after every test
        closeCurrentWindow(threadDriver.get());
        threadDriver.remove();
    }
}
