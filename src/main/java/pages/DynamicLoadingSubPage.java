package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionBot;

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

public class DynamicLoadingSubPage{
    //Variables
    WebDriver driver;

    //Locators
    By startButtonLocator = By.xpath("//div[@id='start']/button");
    By loadedTextLocator = By.xpath("//h4[contains(text(),'Hello')]");
    //Constructor
    protected DynamicLoadingSubPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public DynamicLoadingSubPage clickOnStartButton() throws IOException {
       press(driver,startButtonLocator);
    return this;
    }

    public String getLoadedText() throws IOException {
        return readText(driver,loadedTextLocator);
    }

}
