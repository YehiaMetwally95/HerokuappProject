package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DropDownTests extends BaseTest {

 private String DropDownSelectedValue = "Option 1";
    List dropDownOptions = new ArrayList();

    @BeforeMethod
    private void filldropDownList(){
        dropDownOptions.add("Please select an option");
        dropDownOptions.add("Option 1");
        dropDownOptions.add("Option 2");
    }

    @Test
public void getDropDownValue() throws IOException {
    Assert.assertEquals(
            new HomePage(driver)
                    .clickOnDropDownPage()
                    .selectFromDropDown("1")
                    .getTheSelectedOption()
            ,DropDownSelectedValue);
}

    @Test
    public void checkAllDropDownValues() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnDropDownPage()
                        .getAllActualOptions()

                ,dropDownOptions);
    }
}
