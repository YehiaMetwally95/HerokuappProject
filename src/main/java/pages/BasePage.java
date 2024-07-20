package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.WindowManager;

import java.time.Duration;

public class BasePage {
    //Variables
    private final int Timeout = 30;
    private final int Polling = 250;

    private WebDriver driver;
    private Wait<WebDriver> wait;

    //Constructor
    protected BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Timeout))
                .pollingEvery(Duration.ofMillis(Polling))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }

    //Actions
    protected WebDriver getDriver() {
        return driver;
    }
    protected Wait<WebDriver> getWait() {
        return wait;
    }

    public WindowManager getWindowManager()
    {
        return new WindowManager(driver);
    }
}



