package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

import java.io.File;
import java.io.IOException;

public class CommonTests {

    //variables

    protected WebDriver driver;
    private final static String url = "https://the-internet.herokuapp.com/";

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
    public void deleteFiles() throws IOException {

        File file = new File("src/test/resources/ScreenshotsForButtons");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }

        file = new File("src/test/resources/ScreenshotsForFailure");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }

        file = new File("src/test/resources/ScreenshotsForSuccess");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }

        file = new File("src/test/resources/ScreenshotsForTextBoxes");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }

        file = new File("src/test/resources/ScreenshotsForWebElements");
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }

        }


    @BeforeMethod
    public void setUpAndOpenBrowser()
    {
        //Open Browser
        driver= new ChromeDriver(BrowserOptions.getChromeOptions());

        //Register a Listener that listen to driver actions
        EventListener Listener = new EventListener();
        driver = new EventFiringDecorator(Listener).decorate(driver);

        //Perform actions on Window Manager
        getWindowManager().maximizeWindow();
        getWindowManager().navigateToURL(url);
    }

    @AfterMethod
    public void tearDownBrowser(ITestResult result) throws IOException {

        //Delete All Cookies
        getCookiesManager().deleteAllCookies();

        //Take Screenshot after every successful test
        getScreenshot().captureSuccess(result.getStatus() ,result.getName());

        //Take Screenshot after every failed test
        getScreenshot().captureFailure(result.getStatus() ,result.getName() );

        //Close Browser after every test
        getWindowManager().closeCurrentWindow();
    }


}
