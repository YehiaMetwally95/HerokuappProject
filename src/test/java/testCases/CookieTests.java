package testCases;

import baseTest.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CookiesManager;

import static utils.CookiesManager.*;

public class CookieTests extends BaseTest {

    @Test
    public void addNewCookie()
    {
        Cookie cookie1 = buildCookie("newCookieName"
                ,"12345","the-internet.herokuapp.com");

        addCookie(driver,cookie1);

        Cookie cookie2 = getCookieByName(driver,"newCookieName");

        Assert.assertEquals(cookie1,cookie2);
    }

    @Test
    public void deleteExistingCookie()
    {
        Cookie cookie1 = getCookieByName(driver,"optimizelyBuckets");
        deleteCookie(driver,cookie1);

        Cookie cookie2 = getCookieByName(driver,"optimizelyBuckets");

        Assert.assertNull(cookie2);
    }

    @Test
    public void deleteAllCookiesAfterTest()
    {
        deleteAllCookies(driver);

        Assert.assertEquals(
                getCookiesNumber(driver)
                , 0
        );
    }

}
