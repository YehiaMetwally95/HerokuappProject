package baseTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.*;

import java.io.*;
import java.sql.SQLException;
import java.util.Map;


public class LinearTests {
    public WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(LinearTests.class);
     String query = "SELECT * FROM yehiadb1.usercredentials ORDER BY Username ASC";
     String filepath = "src/test/resources/TestDataJsonFiles/LoginCredentials.json";
     String[] jsonKeys = {"Username","Password","Massage"};
     String[] jsonMainKeys = {"ValidCredentials","InvalidUserCredentials",
             "InvalidPasswordCredentials"};

    JsonFileManager json = new JsonFileManager(filepath);
    @Test
    public void test() throws IOException, SQLException {
    }

    @Test
    public void test2() throws IOException, SQLException, ParseException {
     json.setTestData("InvalidPasswordCredentials.Password"
                ,TestDataGenerator.generateStrongPassword());
     json.setTestData("InvalidUserCredentials.Username"
                ,TestDataGenerator.generateName());
    }

    @Test
    public void setUpAndOpenBrowser() throws ParseException {

        JSONObject a = new JSONObject();
        a.put("key1","value1");
        a.put("key2","value2");

        JSONObject b = new JSONObject();
        b.put("key3","value3");
        b.put("key4","value4");

        JSONObject c = new JSONObject();
        b.put("Var1","Zero1");
        b.put("Zero2","Zero2");

        JSONObject d = new JSONObject();
        b.put("Var3","Zero3");
        b.put("Zero4","Zero4");

        JSONArray e = new JSONArray();
        e.add(0,c);
        e.add(1,d);

        JSONObject f = new JSONObject();


        System.out.println(f);


    }
}
