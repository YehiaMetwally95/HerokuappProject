package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static utils.ActionBot.*;
import static utils.AlertsActions.*;

public class AlertsPage {

    //Variables
    WebDriver driver;

    //Locators
    By triggerJSAlertButton = By.xpath("//button[.='Click for JS Alert']");
    By triggerJSConfirmButton = By.xpath("//button[.='Click for JS Confirm']");
    By triggerJSPromptButton = By.xpath("//button[.='Click for JS Prompt']");
    By resultText = By.id("result");

    //Constructor
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public AlertsPage clickOnJSAlertTriggerButton() throws IOException {
         press(driver,triggerJSAlertButton);
         return this;
    }

    public AlertsPage clickOnJSAlertConfirmButton() throws IOException {
        press(driver,triggerJSConfirmButton);
        return this;
    }

    public AlertsPage clickOnJSAlertPromptButton() throws IOException {
        press(driver,triggerJSPromptButton);
        return this;
    }

    public AlertsPage acceptTheAlert()
    {
        acceptAlert(driver);
        return this;
    }

    public AlertsPage dismissTheAlert()
    {
        dismissAlert(driver);
        return this;
    }

    public AlertsPage typeTheTextInAlert(String text)
    {
        typeTextInAlert(driver,text);
        return this;
    }

    public String getTheTextInAlert()
    {
        return getTextInAlert(driver);
    }

    public String getTheResultText()
    {
        return readText(driver,resultText);
    }
}
