package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import pages.BasePage;
import pages.HoverSubPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionBot extends BasePage {

    //Constructor
    public ActionBot(WebDriver driver)
    {
        super(driver);
    }

    //ActionBot1 for Typing on TextBox
    public void type (By locator , String text) throws IOException {
        getWait().until(f -> {
            getDriver().findElement(locator).clear();
            getDriver().findElement(locator).sendKeys(text);
            return true;
        });

       File source = getDriver().findElement(locator).getScreenshotAs(OutputType.FILE);
       File destination =
               new File ("src/test/resources/ScreenshotsForTextBoxes/"+getDriver().findElement(locator).getAttribute("name")+".png");
       FileHandler.copy(source,destination);
    }

    //ActionBot2 for Pressing on Button or Link
    public void press(By locator) throws IOException {

        getWait().until(f -> {
            getDriver().findElement(locator).click();
            return true;
         });
    }

    //ActionBot3 for Hover on Main-menu & Sub-menu
    public void hovertoSubMenu(By mainMenuLocator , By subMenuLocator) {
        getWait().until(f -> {
            new Actions(getDriver())
                    .moveToElement(getDriver().findElement(mainMenuLocator))
                    .pause(Duration.ofMillis(100))
                    .moveToElement(getDriver().findElement(subMenuLocator))
                    .click()
                    .perform();
            return true;
        });
    }
}
