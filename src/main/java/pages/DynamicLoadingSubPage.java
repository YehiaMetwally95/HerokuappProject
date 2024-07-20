package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingSubPage extends BasePage {
    //Variables

    //Locators
    By startButtonLocator = By.xpath("//div[@id='start']/button");
    By loadedTextLocator = By.xpath("//h4[contains(text(),'Hello')]");
    //Constructor
    protected DynamicLoadingSubPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public DynamicLoadingSubPage clickOnStartButton() {
        getWait().until(f -> {
            getDriver().findElement(startButtonLocator).click();
            return true;
        });
    return this;
    }

    public String getLoadedText() {
        getWait().until(ExpectedConditions.elementToBeClickable(loadedTextLocator));
        return getDriver().findElement(loadedTextLocator).getText();
    }

}
