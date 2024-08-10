package baseTest;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

        String key = "Yehia.Metwally.Mohamed";
        String[] arrofSTG = key.split("\\.",2);
        System.out.println(arrofSTG[0]);
        System.out.println(arrofSTG[1]);


    }
}
