package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class HoverTests extends BaseTest {

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
