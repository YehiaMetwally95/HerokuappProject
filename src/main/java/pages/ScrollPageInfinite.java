package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ScrollActions;

public class ScrollPageInfinite{
    //Variables
    WebDriver driver;
    ScrollActions scroll;
    int scrollStep = 500;
    //Locators
    By targetElement = By.xpath("(//div[@class='jscroll-added'])[10]");
    //Constructor
    protected ScrollPageInfinite(WebDriver driver) {
        this.driver = driver;
        scroll = new ScrollActions(driver);
    }

    //Actions
    public void scrollDownToTenthParagraph()
    {
        scroll.scrollDownTillElementDisplayed(targetElement,scrollStep);
    }
}
