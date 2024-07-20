package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage extends BasePage {
    //Variables

    //Locators
    By dropdownLocator = By.id("dropdown");
    //Constructor
    protected DropDownPage(WebDriver driver) {
        super(driver);
    }

    //Actions

    public DropDownPage selectFromDropDown(String value)
    {
        dropDownElement().selectByValue(value);
        return this;
    }

    public List<String> getAllActualOptions()
    {
        List<WebElement> options = dropDownElement().getOptions();
        return options.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public String getSelectedOption()
    {
        return dropDownElement().getFirstSelectedOption().getText();
    }

    private Select dropDownElement()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        return new Select(getDriver().findElement(dropdownLocator));
    }

}
