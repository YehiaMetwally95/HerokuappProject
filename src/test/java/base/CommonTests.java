package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;
import utils.*;

public class CommonTests {

    //variables
    protected WebDriver driver;
    private final static String url = "https://the-internet.herokuapp.com/";
    Cookie cookie1 = getCookiesManager()
            .buildCookie("newCookieName","12345","the-internet.herokuapp.com");

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
    public void setUp()
    {
        var customListener = new EventReporter();
        driver = new EventFiringDecorator(customListener)
                .decorate(new ChromeDriver(BrowserOptions.getChromeOptions()));
    }

    @BeforeMethod
    public void openBrowser()
    {
        getWindowManager().maximizeWindow();
        getWindowManager().navigateToURL(url);

        getCookiesManager().addCookie(cookie1);
    }

    @AfterMethod
    public void tearDownBrowser()
    {
        Cookie cookie2 = getCookiesManager().getCookieByName("optimizelyBuckets");
        getCookiesManager().deleteCookie(cookie2);

        getCookiesManager().deleteAllCookies();

        getWindowManager().closeCurrentWindow();
    }


}
