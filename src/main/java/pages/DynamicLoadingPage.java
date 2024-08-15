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

public class DynamicLoadingPage {
    //Variables
    WebDriver driver;

    //Locators
    By ExampleTwoLinkLocator = By.linkText("Example 2: Element rendered after the fact");

    //Constructor
    protected DynamicLoadingPage(WebDriver driver) {
        this.driver=driver;
    }

    //Actions
    public DynamicLoadingSubPage clickOnExample2Link() throws IOException {
        press(driver,ExampleTwoLinkLocator);
    return new DynamicLoadingSubPage(driver);
    }
}