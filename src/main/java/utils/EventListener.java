package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.IOException;

public class EventListener implements WebDriverListener
{
    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        System.out.println("Clicking on " + element.getText());

        File source = element.getScreenshotAs(OutputType.FILE);
        File destination = new File ("src/test/resources/Screenshots/ScreenshotsForButtons/"+element.getText()+".png");
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result)
    {
        WebDriverListener.super.afterFindElement(driver,locator,result);

        WebElement element = driver.findElement(locator);
        File source = element.getScreenshotAs(OutputType.FILE);
        File destination = new File ("src/test/resources/Screenshots/ScreenshotsForWebElements/"+element.getText()+"-"+element.getAttribute("id")+".png");
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Element " + result);
    }

}

