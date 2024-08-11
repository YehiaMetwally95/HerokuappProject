package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.JsonFileWriter.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

public class LoginPage {
    //Variables
    WebDriver driver;
    //Locators
    By usernameLocator = By.xpath("//input[@id='username']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By errorAlertLocator = By.id("flash");

    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Actions
    @Step("Enter Username")
    public LoginPage setUsername(String username) throws IOException {
        type(driver,usernameLocator,username);
        return this;
    }

    @Step("Enter Password")
    public LoginPage setPassword(String password) throws IOException {
        type(driver,passwordLocator,password);
        return this;
    }

    @Step("Click on Submit Button")
    public LoginSubPage clickLoginButtonSuccess() throws IOException {

        press(driver,loginButtonLocator);
        return new LoginSubPage(driver);
    }

    @Step("Click on Submit Button")
    public LoginPage clickLoginButtonFailure() throws IOException {

        press(driver,loginButtonLocator);
        return this;
    }

    @Step("Verify Error Massage")
    public LoginPage verifyErrorAlert(String errorAlert) throws IOException {
        Assert.assertEquals(readText(driver,errorAlertLocator)
        ,errorAlert);
        return this;
    }
}
