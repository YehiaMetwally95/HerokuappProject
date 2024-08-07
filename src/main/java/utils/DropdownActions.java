package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownActions {

    WebDriver driver;

    //Constructor
    public DropdownActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectFromDropdownByValue(By dropdown , String value)
    {
        dropDownElement(dropdown).selectByValue(value);
    }

    public void selectFromDropdownByIndex(By dropdown , int index)
    {
        dropDownElement(dropdown).selectByIndex(index);
    }

    public void selectFromDropdownByText(By dropdown , String text)
    {
        dropDownElement(dropdown).selectByVisibleText(text);
    }

    public List<String> getAllOptionsAsString(By dropdown)
    {
        List<WebElement> options = dropDownElement(dropdown).getOptions();
        return options.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public String getSelectedOption(By dropdown)
    {
        return dropDownElement(dropdown).getFirstSelectedOption().getText();
    }

    public void deselectAllOptions(By dropdown)
    {
        dropDownElement(dropdown).deselectAll();
    }

    private Select dropDownElement(By dropdownLocator)
    {
        Waits.getFluentWait(driver).until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        return new Select(driver.findElement(dropdownLocator));
    }
}
