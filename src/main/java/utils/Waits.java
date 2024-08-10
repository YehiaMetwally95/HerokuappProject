package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    static int implicitWaitTimeout = 5;
    static int ExplicitWaitTimeout = 5;
    static int FluentWaitTimeout = 30;
    static int FluentWaitPolling = 250;

    public static void getImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeout));
    }

    public static Wait<WebDriver> getExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(ExplicitWaitTimeout));
    }

    public static Wait<WebDriver> getFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(FluentWaitTimeout))
                .pollingEvery(Duration.ofMillis(FluentWaitPolling))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
