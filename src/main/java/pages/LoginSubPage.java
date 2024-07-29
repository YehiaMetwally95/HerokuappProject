package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSubPage extends BasePage {
    //Variables

    //Locators
    By welcomeTextLocator = By.xpath("//h4[contains(text(),'Welcome')]");

    //Constructor
    protected LoginSubPage(WebDriver driver)
    {
        super(driver);
    }

    //Actions
    public String getWelcomeText()
    {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(welcomeTextLocator));
        return getDriver().findElement(welcomeTextLocator).getText();
    }
}
