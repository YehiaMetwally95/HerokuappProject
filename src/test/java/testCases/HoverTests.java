package testCases;

import baseTest.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverTests extends CommonTests {

    String displayedText = "Not Found";

    @Test
    public void VerifyDisplayedText()
    {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnHovers()
                        .clickOnViewProfile()
                        .getDisplayedText()
                , displayedText
        );
    }
}
