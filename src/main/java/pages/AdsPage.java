package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.io.IOException;

public class AdsPage {
    //Variables
    WebDriver driver;
    ActionBot bot;

    //Locators
    By adTitle = By.cssSelector(".modal-title h3");
    By closeButton = By.cssSelector(".modal-footer p");
    By originalPageTitle = By.cssSelector(".example h3");

    //Constructor
    public AdsPage(WebDriver driver) {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    public String getAdTitle() {
        return bot.readText(adTitle);
    }

    public AdsPage closeAd() throws IOException {
        bot.press(closeButton);
        return this;
    }

    public String VerifyAdisClosed() throws IOException {
        return bot.readText(originalPageTitle);
    }

}
