package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.JsonFileWriter.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

public class HoverSubPage {

    //Variables
    WebDriver driver;

    //Locators
    By displayedText = By.xpath("//body/h1");

    //Constructor
    protected HoverSubPage (WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public String getDisplayedText()
    {
        return readText(driver,displayedText);
    }
}
