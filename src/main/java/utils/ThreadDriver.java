package utils;

import org.openqa.selenium.WebDriver;

public class ThreadDriver {

    public static WebDriver setIsolatedDriver (WebDriver driver)
    {
        ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>();
        threadDriver.set(driver);
        return threadDriver.get();
    }

    public static void removeIsolatedDriver (WebDriver isolatedDriver)
    {
        ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>();
        threadDriver.remove();
    }
}
