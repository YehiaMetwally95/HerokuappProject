package testcases;

import base.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DynamicLoadingTests extends CommonTests {

    private String LoadedText = "Hello World!";

    @Test
public void getLoadedText()
    {
        Assert.assertEquals(
            new HomePage(driver)
                .clickOnDynamicLoadingPage()
                .clickOnExample2Link()
                .clickOnStartButton()
                    .getLoadedText()
        ,LoadedText);
    }
}
