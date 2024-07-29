package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //Variables

    //Locators
    By formAuthenticationLocator = By.linkText("Form Authentication");
    By dynamicLoadingLocator = By.linkText("Dynamic Loading");
    By dropDownLocator = By.linkText("Dropdown");
    By LargeAndDeepDom = By.linkText("Large & Deep DOM");
    By InfiniteScroll = By.linkText("Infinite Scroll");
    By hovers=By.linkText("Hovers");

    //Constructor
    public HomePage (WebDriver driver)
    {
    super(driver);
    }

    //Actions
    public LoginPage clickOnLoginPage()
    {
      click(formAuthenticationLocator);
    return new LoginPage(getDriver());
    }

    public DynamicLoadingPage clickOnDynamicLoadingPage()
    {
        click(dynamicLoadingLocator);
    return new DynamicLoadingPage(getDriver());
    }

    public DropDownPage clickOnDropDownPage()
    {
        click(dropDownLocator);
        return new DropDownPage(getDriver());
    }

    public ScrollPage clickOnLargeAndDeemDom()
    {
        click(LargeAndDeepDom);
        return new ScrollPage(getDriver());
    }

    public InfiniteScrollPage clickOnInfiniteScroll()
    {
        click(InfiniteScroll);
        return new InfiniteScrollPage(getDriver());
    }

    public HoverPage clickOnHovers()
    {
        click(hovers);
        return new HoverPage(getDriver());
    }

    private void click (By locator)
    {
        getWait().until(f -> {
            getDriver().findElement(locator).click();
            return true;
        });
    }

}
