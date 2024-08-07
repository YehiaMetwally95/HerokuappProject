package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AlertsActions {
    WebDriver driver;

    //Constructor
    public AlertsActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void acceptAlert()
    {
        Waits.getFluentWait(driver).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert()
    {
        Waits.getFluentWait(driver).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void typeTextInAlert(String text)
    {
        Waits.getFluentWait(driver).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    public String getTextInAlert()
    {
        Waits.getFluentWait(driver).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
}
