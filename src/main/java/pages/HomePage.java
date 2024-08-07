package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import utils.Waits;

public class HomePage {
    //Variables
    WebDriver driver;

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
    }

    @Step("Navigate To Login Page")
    //Actions
    public LoginPage clickOnLoginPage()
    {
      click(formAuthenticationLocator);
    return new LoginPage(driver);
    }

    public DynamicLoadingPage clickOnDynamicLoadingPage()
    {
        click(dynamicLoadingLocator);
    return new DynamicLoadingPage(driver);
    }

    public DropDownPage clickOnDropDownPage()
    {
        click(dropDownLocator);
        return new DropDownPage(driver);
    }

    public ScrollPage clickOnLargeAndDeemDom()
    {
        click(largeAndDeepDom);
        return new ScrollPage(driver);
    }

    public ScrollPageInfinite clickOnInfiniteScroll()
    {
        click(infiniteScroll);
        return new ScrollPageInfinite(driver);
    }

    public HoverPage clickOnHovers()
    {
        click(hovers);
        return new HoverPage(driver);
    }

    public AlertsPage clickOnAlertsPage()
    {
        click(alertsPage);
        return new AlertsPage(driver);
    }

    public FileUploadPage clickOnFileUploadPage() {
        click(fileUploadPage);
        return new FileUploadPage(driver);
    }

    public AdsPage clickOnAdsPage()
    {
        click(adsPage);
        return new AdsPage(driver);
    }

    private void click (By locator)
    {
        Waits.getFluentWait(driver).until(f -> {
            driver.findElement(locator).click();
            return true;
        });
    }

}
