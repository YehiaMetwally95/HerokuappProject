package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowManager {

    WebDriver driver;

    public WindowManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateForward()
    {
    driver.navigate().forward();
    }

    public void navigateBackward()
    {
        driver.navigate().back();
    }

    public void refreshWindow()
    {
        driver.navigate().refresh();
    }

    public void navigateToURL(String url)
    {
        driver.navigate().to(url);
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public void  minimizeWindow()
    {
        driver.manage().window().minimize();
    }

    public void fullScreenWindow()
    {
        driver.manage().window().fullscreen();
    }

    public void closeCurrentWindow()
    {
        driver.close();
    }
}
