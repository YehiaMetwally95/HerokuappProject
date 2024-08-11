package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionBot {

    //ActionBot1 for Typing on TextBox
    public static void type (WebDriver driver , By locator , String text) throws IOException {
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typing " + text);

        File source = driver.findElement(locator).getScreenshotAs(OutputType.FILE);
       File destination =
               new File ("src/test/resources/Screenshots/ScreenshotsForTextBoxes/"+driver.findElement(locator).getAttribute("name")+".png");
       FileHandler.copy(source,destination);
    }

    //ActionBot2 for Pressing on Button or Link
    public static void press(WebDriver driver,By locator) throws IOException {

        Waits.getFluentWait(driver).until(f -> {
            System.out.println("Clicking On " + driver.findElement(locator).getText());
            driver.findElement(locator).click();
            return true;
         });

    }

    //ActionBot3 for Get Text from Element
    public static String readText(WebDriver driver,By locator){
        Waits.getFluentWait(driver).until(f -> {
          driver.findElement(locator).getText();
            return true;
        });
        return driver.findElement(locator).getText().replace("\n","");
    }

    //ActionBot4 for Verify Element is Displayed
    public static boolean isElementDisplayed(WebDriver driver,By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isDisplayed();
            return true;
        });
        return true;
    }

    //ActionBot5 for Verify Element is Enabled
    public static boolean isElementEnabled(WebDriver driver,By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isEnabled();
            return true;
        });
        return true;
    }

    //ActionBot6 for Verify Element is Selected
    public static boolean isElementSelected(WebDriver driver,By locator){
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).isSelected();
            return true;
        });
        return true;
    }

    //ActionBot7 for Hover on Main-menu & Sub-menu
    public static void hoverToSubMenu(WebDriver driver,By mainMenuLocator , By subMenuLocator) {
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
