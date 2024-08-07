package testCases;

import baseTest.CommonTests;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookieTests extends CommonTests {

    @Test
    public void addNewCookie()
    {
        Cookie cookie1 = getCookiesManager().buildCookie("newCookieName"
                ,"12345","the-internet.herokuapp.com");
        getCookiesManager().addCookie(cookie1);

        Cookie cookie2 = getCookiesManager()
                .getCookieByName("newCookieName");

        Assert.assertEquals(cookie1,cookie2);
    }

    @Test
    public void deleteExistingCookie()
    {
        Cookie cookie1 = getCookiesManager()
                .getCookieByName("optimizelyBuckets");
        getCookiesManager().deleteCookie(cookie1);

        Cookie cookie2 = getCookiesManager()
                .getCookieByName("optimizelyBuckets");

        Assert.assertNull(cookie2);
    }

    @Test
    public void deleteAllCookies()
    {
        getCookiesManager().deleteAllCookies();

        Assert.assertEquals(
                getCookiesManager().getCookiesNumber()
                , 0
        );
    }

}
