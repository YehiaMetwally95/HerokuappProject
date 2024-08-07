package testCases;

import baseTest.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class DynamicLoadingTests extends CommonTests {

    private String LoadedText = "Hello World!";

    @Test
public void getLoadedText() throws IOException {
        Assert.assertEquals(
            new HomePage(driver)
                .clickOnDynamicLoadingPage()
                .clickOnExample2Link()
                .clickOnStartButton()
                    .getLoadedText()
        ,LoadedText);
    }
}