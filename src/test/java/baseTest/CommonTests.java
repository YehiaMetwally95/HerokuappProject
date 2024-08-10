package baseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

import java.io.File;
import java.io.IOException;

public class CommonTests {

    //Variables
    public WebDriver driver;
    public String url = "https://the-internet.herokuapp.com/";

    //Methods
    public Screenshot getScreenshot()
    {
        return new Screenshot(driver);
    }

    public WindowManager getWindowManager()
    {
        return new WindowManager(driver);
    }

    public CookiesManager getCookiesManager()
    {
        return new CookiesManager(driver);
    }

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
    public void setUpAndOpenBrowser()
    {
        //Open Browser
        driver= new ChromeDriver(BrowserOptions.getChromeOptions());

        //Perform actions on Window Manager
        getWindowManager().maximizeWindow();
        getWindowManager().navigateToURL(url);
    }

    @AfterMethod
    public void getScreenshots(ITestResult result) throws IOException {

        //Take Screenshot after every successful test
        getScreenshot().captureSuccess(result);

        //Take Screenshot after every failed test
        getScreenshot().captureFailure(result);
    }

    @AfterMethod (dependsOnMethods = "getScreenshots")
    public void tearDownBrowser(){

        //Delete All Cookies
        getCookiesManager().deleteAllCookies();

        //Close Browser after every test
       getWindowManager().closeCurrentWindow();
    }
}
