package baseTest;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.*;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LinearTests {
    public WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(LinearTests.class);
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/yehiadb1";
     String dbUser = "root";
     String dbPassword = "yehia";
     String query = "SELECT * FROM yehiadb1.usercredentials ORDER BY Username ASC";
     String filepath = "src/test/resources/TestDataJsonFiles/LoginCredentials.json";
     String[] jsonKeys = {"Username","Password","Massage"};
     String[] jsonMainKeys = {"ValidCredentials","InvalidUserCredentials",
             "InvalidPasswordCredentials"};

    JsonFileReader json = new JsonFileReader(filepath);
    @Test
    public void test() throws IOException, SQLException {
        JDBC.setJsonFileFromDB(dbUrl,dbUser,dbPassword,query,filepath,jsonKeys);
    }

    @Test
    public void test2() throws IOException, SQLException, ParseException {
     JDBC.setJsonFileFromDB(dbUrl,dbUser,dbPassword,query,filepath,jsonKeys,jsonMainKeys);
     json.setTestData("InvalidPasswordCredentials.Password"
                ,TestDataGenerator.generateStrongPassword());
     json.setTestData("InvalidUserCredentials.Username"
                ,TestDataGenerator.generateName());
    }

    @Test
    @Parameters({"URL","BrowserType"})
    public void setUpAndOpenBrowser(String url , String browserType)
    {
        //Open Browser
        switch (browserType)
        {
            case "Chrome" :
                driver= new ChromeDriver(BrowserOptions.getChromeOptions());
                break;

            case "Firefox" :
                driver= new FirefoxDriver(BrowserOptions.getFireFoxOptions());
                break;

            case "Edge" :
                driver= new EdgeDriver(BrowserOptions.getEdgeOptions());

                break;

            default:
                System.out.println("Wrong driver name");
        }
    }
}
