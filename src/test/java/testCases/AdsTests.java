package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.io.IOException;

public class AdsTests extends BaseTest {

    String adTitle = "THIS IS A MODAL WINDOW";
    String originalPageTitle = "Entry Ad";

    @Test
    public void getAdTitle() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAdsPage()
                        .getAdTitle()
                , adTitle
        );
    }

    @Test
    public void closeAd() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAdsPage()
                        .closeAd()
                        .VerifyAdisClosed()
                , originalPageTitle
        );
    }
}
