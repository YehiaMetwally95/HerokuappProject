package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.DropdownActions;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    //Variables
    WebDriver driver;
    DropdownActions dropdownActions;
    //Locators
    By dropdownLocator = By.id("dropdown");
    //Constructor
    protected DropDownPage(WebDriver driver) {
        this.driver = driver;
        dropdownActions = new DropdownActions(driver);
    }

    //Actions

    public DropDownPage selectFromDropDown(String value) {
        dropdownActions.selectFromDropdownByValue(dropdownLocator,value);
        return this;
    }

    public List<String> getAllActualOptions()
    {
       return dropdownActions.getAllOptionsAsString(dropdownLocator);
    }

    public String getSelectedOption()
    {
        return dropdownActions.getSelectedOption(dropdownLocator);
    }

}
