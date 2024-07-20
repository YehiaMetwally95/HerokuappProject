package testcases;

import base.CommonTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class DropDownTests extends CommonTests {

 private String DropDownSelectedValue = "Option 1";
    List dropDownOptions = new ArrayList();

    @BeforeMethod
    private void filldropDownList(){
        dropDownOptions.add("Please select an option");
        dropDownOptions.add("Option 1");
        dropDownOptions.add("Option 2");
    }

    @Test
public void getDropDownValue()
{
    Assert.assertEquals(
            new HomePage(driver)
                    .clickOnDropDownPage()
                    .selectFromDropDown("1")
                    .getSelectedOption()
            ,DropDownSelectedValue);
}

    @Test
    public void checkAllDropDownValues()
    {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnDropDownPage()
                        .getAllActualOptions()

                ,dropDownOptions);
    }
}
