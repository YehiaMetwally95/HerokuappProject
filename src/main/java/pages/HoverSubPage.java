package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.time.Duration;

public class HoverSubPage {

    //Variables
    WebDriver driver;
    ActionBot bot;
    //Locators
    By displayedText = By.xpath("//body/h1");

    //Constructor
    protected HoverSubPage (WebDriver driver) {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    public String getDisplayedText()
    {
        return bot.readText(displayedText);
    }
}
