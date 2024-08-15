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

public class ScrollPage {
    //Variables
    WebDriver driver ;

    //Constructor
    protected ScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By TableLocator = By.id("large-table");
    By headerLocator = By.tagName("h3");
    By footerLocator = By.id("page-footer");

    //Actions
    public ScrollPage scrollDownToTable () {
        scrollDownToElement(driver,TableLocator);
        return this;
    }

    public ScrollPage scrollDownToFooter () {
        scrollDownToElement(driver,footerLocator);
        return this;
    }

    public ScrollPage scrollByGivenAmountFromHeader(int deltaX, int deltaY)
    {
        scrollByGivenAmountFromElement(driver,headerLocator,deltaX,deltaY);
        return this;
    }

    public ScrollPage scrollByGivenAmountFromFooter(int deltaX, int deltaY)
    {
        scrollByGivenAmountFromElement(driver,footerLocator,deltaX,deltaY);
        return this;
    }

}