package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-infobars");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
       // option.addArguments("--headless=new");
        return option;
    }

    public static EdgeOptions getEdgeOptions()
    {
        EdgeOptions option = new EdgeOptions();
        option.addArguments("--disable-infobars");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        option.addArguments("--headless=new");
        return option;
    }

    public static FirefoxOptions getFireFoxOptions()
    {
        FirefoxOptions option = new FirefoxOptions();
        //option.addArguments("-headless");
        return option;
    }




}
