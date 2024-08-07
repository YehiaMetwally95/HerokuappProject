package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionBot;

public class LoginSubPage {
    //Variables
    WebDriver driver;
    ActionBot bot;
    //Locators
    By welcomeTextLocator = By.xpath("//h4[contains(text(),'Welcome')]");

    //Constructor
    public LoginSubPage(WebDriver driver)
    {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    @Step("Verify Welcome Text")
    public LoginSubPage verifyWelcomeText(String welcomeText)
    {
        Assert.assertEquals(
                bot.readText(welcomeTextLocator)
                ,welcomeText
        );
        return this;
    }
}
