package testCases;

import baseTest.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class HoverTests extends CommonTests {

    String displayedText = "Not Found";

    @Test
    public void VerifyDisplayedText() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnHovers()
                        .clickOnViewProfile()
                        .getDisplayedText()
                , displayedText
        );
    }
}
