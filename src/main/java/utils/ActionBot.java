package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionBot {
    WebDriver driver;

    //Constructor
    public ActionBot(WebDriver driver)
    {
        this.driver = driver;
    }

    //ActionBot1 for Typing on TextBox
    public void type (By locator , String text) throws IOException {
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });

       File source = driver.findElement(locator).getScreenshotAs(OutputType.FILE);
       File destination =
               new File ("src/test/resources/Screenshots/ScreenshotsForTextBoxes/"+driver.findElement(locator).getAttribute("name")+".png");
       FileHandler.copy(source,destination);
    }

    //ActionBot2 for Pressing on Button or Link
    public void press(By locator) throws IOException {

        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).click();
            return true;
         });
    }

    //ActionBot3 for Get Text from Element
    public String readText(By locator){
        Waits.getFluentWait(driver).until(f -> {
          driver.findElement(locator).getText();
            return true;
        });
        return driver.findElement(locator).getText();
    }

    //ActionBot4 for Verify Element is Displayed
    public boolean isElementDisplayed(By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isDisplayed();
            return true;
        });
        return true;
    }

    //ActionBot5 for Verify Element is Enabled
    public boolean isElementEnabled(By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isEnabled();
            return true;
        });
        return true;
    }

    //ActionBot6 for Verify Element is Selected
    public boolean isElementSelected(By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isSelected();
            return true;
        });
        return true;
    }

    //ActionBot7 for Hover on Main-menu & Sub-menu
    public void hovertoSubMenu(By mainMenuLocator , By subMenuLocator) {
        Waits.getFluentWait(driver).until(f -> {
            new Actions(driver)
                    .moveToElement(driver.findElement(mainMenuLocator))
                    .pause(Duration.ofMillis(100))
                    .moveToElement(driver.findElement(subMenuLocator))
                    .click()
                    .perform();
            return true;
        });
    }
}
