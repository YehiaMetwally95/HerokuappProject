package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

public class ScrollPageInfinite{
    //Variables
    WebDriver driver;
    int scrollStep = 500;

    //Locators
    By targetElement = By.xpath("(//div[@class='jscroll-added'])[10]");

    //Constructor
    protected ScrollPageInfinite(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void scrollDownToTenthParagraph()
    {
        scrollDownTillElementDisplayed(driver,targetElement,scrollStep);
    }
}
