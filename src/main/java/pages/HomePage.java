package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import utils.ActionBot;
import utils.Waits;

import java.io.IOException;

public class HomePage {
    //Variables
    WebDriver driver;
    ActionBot bot;

    //Locators
    By formAuthenticationLocator = By.linkText("Form Authentication");
    By dynamicLoadingLocator = By.linkText("Dynamic Loading");
    By dropDownLocator = By.linkText("Dropdown");
    By largeAndDeepDom = By.linkText("Large & Deep DOM");
    By infiniteScroll = By.linkText("Infinite Scroll");
    By hovers=By.linkText("Hovers");
    By alertsPage=By.linkText("JavaScript Alerts");
    By fileUploadPage=By.linkText("File Upload");
    By adsPage = By.linkText("Entry Ad");

    //Constructor
    public HomePage (WebDriver driver)
    {
    this.driver=driver;
    bot = new ActionBot(driver);
    }

    @Step("Navigate To Login Page")
    //Actions
    public LoginPage clickOnLoginPage() throws IOException {
      click(formAuthenticationLocator);
    return new LoginPage(driver);
    }

    public DynamicLoadingPage clickOnDynamicLoadingPage() throws IOException {
        click(dynamicLoadingLocator);
    return new DynamicLoadingPage(driver);
    }

    public DropDownPage clickOnDropDownPage() throws IOException {
        click(dropDownLocator);
        return new DropDownPage(driver);
    }

    public ScrollPage clickOnLargeAndDeemDom() throws IOException {
        click(largeAndDeepDom);
        return new ScrollPage(driver);
    }

    public ScrollPageInfinite clickOnInfiniteScroll() throws IOException {
        click(infiniteScroll);
        return new ScrollPageInfinite(driver);
    }

    public HoverPage clickOnHovers() throws IOException {
        click(hovers);
        return new HoverPage(driver);
    }

    public AlertsPage clickOnAlertsPage() throws IOException {
        click(alertsPage);
        return new AlertsPage(driver);
    }

    public FileUploadPage clickOnFileUploadPage() throws IOException {
        click(fileUploadPage);
        return new FileUploadPage(driver);
    }

    public AdsPage clickOnAdsPage() throws IOException {
        click(adsPage);
        return new AdsPage(driver);
    }

    private void click (By locator) throws IOException {
       bot.press(locator);
    }

}
