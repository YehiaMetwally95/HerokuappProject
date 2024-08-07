package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScrollActions;
import utils.WindowManager;

public class ScrollPage {
    //Variables
    WebDriver driver ;
    ScrollActions scroll;
    //Locators
    By TableLocator = By.id("large-table");
    By headerLocator = By.tagName("h3");
    By footerLocator = By.id("page-footer");

    //Constructor
    protected ScrollPage(WebDriver driver) {
        this.driver = driver;
        scroll = new ScrollActions(driver);
    }

    //Actions
    public ScrollPage scrollDownToTable () {
        scroll.scrollDownToElement(TableLocator);
        return this;
    }

    public ScrollPage scrollDownToFooter () {
        scroll.scrollDownToElement(footerLocator);
        return this;
    }

    public ScrollPage scrollByGivenAmountFromHeader(int deltaX, int deltaY)
    {
        scroll.scrollByGivenAmountFromElement(headerLocator,deltaX,deltaY);
        return this;
    }

    public ScrollPage scrollByGivenAmountFromFooter(int deltaX, int deltaY)
    {
        scroll.scrollByGivenAmountFromElement(footerLocator,deltaX,deltaY);
        return this;
    }

}