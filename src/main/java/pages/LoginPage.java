package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    //Variables

    //Locators
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By errorAlertLocator = By.id("flash");

    //Constructor
    protected LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Actions
    public LoginPage setUsername(String username)
    {
        getWait().until(f -> {
            getDriver().findElement(usernameLocator).sendKeys(username);
            return true;
        });
    return this;
    }

    public LoginPage setPassword(String password)
    {
        getWait().until(f -> {
            getDriver().findElement(passwordLocator).sendKeys(password);
            return true;
        });
        return this;
    }

    public LoginSubPage clickLoginButtonSuccess()
    {
        getWait().until(f -> {
            getDriver().findElement(loginButtonLocator).click();
            return true;
        });
    return new LoginSubPage(getDriver());
    }

    public LoginPage clickLoginButtonFailure()
    {
        getWait().until(f -> {
            getDriver().findElement(loginButtonLocator).click();
            return true;
        });
        return new LoginPage(getDriver());
    }

    public String getErrorAlert()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(errorAlertLocator));
        return getDriver().findElement(errorAlertLocator).getText();
    }
}
