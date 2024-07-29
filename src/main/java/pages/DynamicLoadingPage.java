package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionBot;

import java.io.IOException;

public class DynamicLoadingPage extends BasePage {
    //Variables
    ActionBot bot = new ActionBot(getDriver());

    //Locators
    By ExampleTwoLinkLocator = By.linkText("Example 2: Element rendered after the fact");

    //Constructor
    protected DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public DynamicLoadingSubPage clickOnExample2Link() throws IOException {
        bot.press(ExampleTwoLinkLocator);
    return new DynamicLoadingSubPage(getDriver());
    }
}