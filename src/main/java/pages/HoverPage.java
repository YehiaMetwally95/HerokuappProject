package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ActionBot;

import java.time.Duration;

public class HoverPage {

    //Variables
    WebDriver driver;
    ActionBot bot ;
    //Locators
    By mainMenu = By.xpath("(//div[@class='figure']/img)[1]");
    By subMenu = By.xpath("//div[@class='figcaption']/a[@href='/users/1']");

    //Constructor
    protected HoverPage(WebDriver driver) {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    public HoverSubPage clickOnViewProfile()
    {
        bot.hovertoSubMenu(mainMenu,subMenu);
    return new HoverSubPage(driver);
    }
}
