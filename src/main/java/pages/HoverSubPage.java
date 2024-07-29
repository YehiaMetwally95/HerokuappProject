package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HoverSubPage extends BasePage {

    //Variables

    //Locators
    By displayedText = By.xpath("//body/h1");

    //Constructor
    protected HoverSubPage (WebDriver driver) {
        super(driver);
    }

    //Actions
    public String getDisplayedText()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(displayedText));
            getDriver().findElement(displayedText).getText();
            return getDriver().findElement(displayedText).getText();
    }
}
