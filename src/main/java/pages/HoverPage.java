package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class HoverPage {

    //Variables
    WebDriver driver;

    //Locators
    By mainMenu = By.xpath("(//div[@class='figure']/img)[1]");
    By subMenu = By.xpath("//div[@class='figcaption']/a[@href='/users/1']");

    //Constructor
    protected HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public HoverSubPage clickOnViewProfile()
    {
        hoverToSubMenu(driver,mainMenu,subMenu);
    return new HoverSubPage(driver);
    }
}
