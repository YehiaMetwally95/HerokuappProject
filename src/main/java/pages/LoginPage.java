package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.io.IOException;

public class LoginPage extends BasePage {
    //Variables
    ActionBot bot = new ActionBot(getDriver());
    //Locators
    By usernameLocator = By.xpath("//input[@id='username']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By errorAlertLocator = By.id("flash");

    //Constructor
    protected LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //Actions
    public LoginPage setUsername(String username) throws IOException {
        bot.type(usernameLocator,username);
        return this;
    }

    public LoginPage setPassword(String password) throws IOException {

        bot.type(passwordLocator,password);
        return this;
    }

    public LoginSubPage clickLoginButtonSuccess() throws IOException {

        bot.press(loginButtonLocator);
    return new LoginSubPage(getDriver());
    }

    public LoginPage clickLoginButtonFailure() throws IOException {

        bot.press(loginButtonLocator);
        return new LoginPage(getDriver());
    }

    public String getErrorAlert()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(errorAlertLocator));
        return getDriver().findElement(errorAlertLocator).getText();
    }
}
