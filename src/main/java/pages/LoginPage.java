package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.io.IOException;

public class LoginPage {
    //Variables
    WebDriver driver;
    ActionBot bot;
    //Locators
    By usernameLocator = By.xpath("//input[@id='username']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By errorAlertLocator = By.id("flash");

    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    @Step("Enter Username")
    public LoginPage setUsername(String username) throws IOException {
        bot.type(usernameLocator,username);
        return this;
    }

    @Step("Enter Password")
    public LoginPage setPassword(String password) throws IOException {
        bot.type(passwordLocator,password);
        return this;
    }

    @Step("Click on Submit Button")
    public LoginSubPage clickLoginButtonSuccess() throws IOException {

        bot.press(loginButtonLocator);
        return new LoginSubPage(driver);
    }

    @Step("Click on Submit Button")
    public LoginPage clickLoginButtonFailure() throws IOException {

        bot.press(loginButtonLocator);
        return this;
    }

    @Step("Verify Error Massage")
    public LoginPage verifyErrorAlert(String errorAlert){
        Assert.assertTrue(bot.readText(errorAlertLocator).contains(errorAlert));
        return this;
    }
}
