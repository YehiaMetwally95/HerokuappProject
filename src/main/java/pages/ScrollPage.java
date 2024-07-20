package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WindowManager;

public class ScrollPage extends BasePage {
    //Variables

    //Locators
    By TableLocator = By.id("large-table");
    By headerLocator = By.tagName("h3");
    By footerLocator = By.id("page-footer");
    By targetElement = By.xpath("(//div[@class='jscroll-added'])[5]");
    //Constructor
    protected ScrollPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void scrollDownToTable () {
        WebElement table = getDriver().findElement(TableLocator);
        new Actions(getDriver()).scrollToElement(table).perform();
    }

    public ScrollPage scrollDownToFooter () {
        WebElement table = getDriver().findElement(footerLocator);
        new Actions(getDriver()).scrollToElement(table).perform();
    return this;
    }

    public void scrollByGivenAmountFromHeader(int deltaX, int deltaY)
    {
        WheelInput.ScrollOrigin myOrigin =
                WheelInput.ScrollOrigin.fromElement(getDriver().findElement(headerLocator));
        new Actions(getDriver()).scrollByAmount(deltaX,deltaY).perform();
    }

    public void scrollByGivenAmountFromFooter(int deltaX, int deltaY)
    {
        WheelInput.ScrollOrigin myOrigin =
                WheelInput.ScrollOrigin
                        .fromElement(getDriver().findElement(footerLocator));
        new Actions(getDriver()).scrollByAmount(deltaX,deltaY).perform();
    }

}