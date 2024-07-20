package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    //Variables

    //Locators
    By ExampleTwoLinkLocator = By.xpath("//a[contains(text(),'Example 2')]");

    //Constructor
    protected DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public DynamicLoadingSubPage clickOnExample2Link() {
        getWait().until(f -> {
            getDriver().findElement(ExampleTwoLinkLocator).click();
            return true;
        });
    return new DynamicLoadingSubPage(getDriver());
    }
}