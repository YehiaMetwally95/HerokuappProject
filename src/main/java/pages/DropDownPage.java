package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

import static utils.DropdownActions.*;

public class DropDownPage {
    //Variables
    WebDriver driver;

    //Locators
    By dropdownLocator = By.id("dropdown");
    //Constructor
    protected DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions

    public DropDownPage selectFromDropDown(String value) {
       selectFromDropdownByValue(driver,dropdownLocator,value);
        return this;
    }

    public List<String> getAllActualOptions()
    {
       return getAllOptionsAsString(driver,dropdownLocator);
    }

    public String getTheSelectedOption()
    {
        return getSelectedOption(driver,dropdownLocator);
    }

}
