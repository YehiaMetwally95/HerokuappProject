package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

import static utils.ActionBot.readText;

public class AdsPage {
    //Variables
    WebDriver driver;

    //Locators
    By adTitle = By.cssSelector(".modal-title h3");
    By closeButton = By.cssSelector(".modal-footer p");
    By originalPageTitle = By.cssSelector(".example h3");

    //Constructor
    public AdsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public String getAdTitle() throws IOException {
        return readText(driver,adTitle);
    }

    public AdsPage closeAd() throws IOException {
        press(driver,closeButton);
        return this;
    }

    public String VerifyAdisClosed() throws IOException {
        return readText(driver,originalPageTitle);
    }

}
