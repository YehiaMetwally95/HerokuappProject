package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class InfiniteScrollPage extends BasePage{
    //Variables
    int scrollStep = 500;
    //Locators
    By targetElement = By.xpath("(//div[@class='jscroll-added'])[5]");
    //Constructor
    protected InfiniteScrollPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void scrollDownToFifthParagraph()
    {
        getWait().until(f->{
            new Actions(getDriver()).scrollByAmount(0,scrollStep).perform();
            getDriver().findElement(targetElement).isDisplayed();
            return true;
        });
    }
}
