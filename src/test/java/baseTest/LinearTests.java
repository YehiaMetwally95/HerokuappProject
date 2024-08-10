package baseTest;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.JDBC;
import utils.JsonFileReader;
import utils.JsonFileWriter;
import utils.TestDataGenerator;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LinearTests {
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
    public void test3() throws IOException, SQLException, ParseException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        By usernameLocator = By.xpath("//input[@id='username']");
        By passwordLocator = By.xpath("//input[@id='password']");
        By text = By.id("flash");
        driver.findElement(usernameLocator).sendKeys("www");
        driver.findElement(passwordLocator).sendKeys("sss", Keys.RETURN);
        System.out.println(driver.findElement(text).getText());


    }
}
