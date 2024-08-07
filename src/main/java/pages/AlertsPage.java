package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;
import utils.AlertsActions;

import java.io.IOException;

public class AlertsPage {

    //Variables
    WebDriver driver;
    ActionBot bot;
    AlertsActions alert;

    //Locators
    By triggerJSAlertButton = By.xpath("//button[.='Click for JS Alert']");
    By triggerJSConfirmButton = By.xpath("//button[.='Click for JS Confirm']");
    By triggerJSPromptButton = By.xpath("//button[.='Click for JS Prompt']");
    By resultText = By.id("result");

    //Constructor
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
         bot = new ActionBot(driver);
         alert = new AlertsActions(driver);
    }

    //Actions
    public AlertsPage clickOnJSAlertTriggerButton() throws IOException {
         bot.press(triggerJSAlertButton);
         return this;
    }

    public AlertsPage clickOnJSAlertConfirmButton() throws IOException {
        bot.press(triggerJSConfirmButton);
        return this;
    }

    public AlertsPage clickOnJSAlertPromptButton() throws IOException {
        bot.press(triggerJSPromptButton);
        return this;
    }

    public AlertsPage acceptAlert()
    {
        alert.acceptAlert();
        return this;
    }

    public AlertsPage dismissAlert()
    {
        alert.dismissAlert();
        return this;
    }

    public AlertsPage typeTextInAlert(String text)
    {
        alert.typeTextInAlert(text);
        return this;
    }

    public String getTextInAlert()
    {
        return alert.getTextInAlert();
    }

    public String getResultText()
    {
        return bot.readText(resultText);
    }
}
