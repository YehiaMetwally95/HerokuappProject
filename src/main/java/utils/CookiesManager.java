package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookiesManager {

    WebDriver driver;

    public CookiesManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public Cookie buildCookie(String name , String value , String url)
    {
        Cookie cookie = new Cookie.Builder(name , value)
                .domain(url)
                .build();
    return cookie;
    }

    public void addCookie(Cookie cookie)
    {
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie)
    {
        driver.manage().deleteCookie(cookie);
    }

    public Cookie getCookieByName(String cookieName)
    {
        return driver.manage().getCookieNamed(cookieName);
    }

    public void deleteAllCookies()
    {
        driver.manage().deleteAllCookies();
    }

    public int getCookiesNumber()
    {
        return driver.manage().getCookies().size();
    }

}
