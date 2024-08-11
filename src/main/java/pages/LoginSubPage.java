package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class LoginSubPage {
    //Variables
    WebDriver driver;
    //Locators
    By welcomeTextLocator = By.xpath("//h4[contains(text(),'Welcome')]");

    //Constructor
    public LoginSubPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Actions
    @Step("Verify Welcome Text")
    public LoginSubPage verifyWelcomeText(String welcomeText)
    {
        Assert.assertEquals(
                readText(driver,welcomeTextLocator)
                ,welcomeText
        );
        return this;
    }
}
