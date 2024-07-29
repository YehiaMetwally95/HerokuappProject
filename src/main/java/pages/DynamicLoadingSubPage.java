package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.io.IOException;

public class DynamicLoadingSubPage extends BasePage {
    //Variables
    ActionBot bot = new ActionBot(getDriver());

    //Locators
    By startButtonLocator = By.xpath("//div[@id='start']/button");
    By loadedTextLocator = By.xpath("//h4[contains(text(),'Hello')]");
    //Constructor
    protected DynamicLoadingSubPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public DynamicLoadingSubPage clickOnStartButton() throws IOException {
       bot.press(startButtonLocator);
    return this;
    }

    public String getLoadedText() {
        getWait().until(ExpectedConditions.elementToBeClickable(loadedTextLocator));
        return getDriver().findElement(loadedTextLocator).getText();
    }

}
