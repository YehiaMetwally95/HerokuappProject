package baseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.*;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;


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
    RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
    String contentType = "application/json";
    String endpoint = "booking/";

    Map login = new HashMap<>();
    login.put("username","admin");
    login.put("password","password123");

    Map map1 = new HashMap();
    Map map2 = new HashMap();
    map2.put("checkin", "2018-01-01");
    map2.put("checkout", "2020-01-01");
    map1.put("firstname","yehia");
    map1.put("lastname","metwally");
    map1.put("totalprice","111");
    map1.put("depositpaid","true");
    map1.put("bookingdates", map2);
    map1.put("additionalneeds","test");

    Response response = APIsManager.MakeRequest("Post","auth",login,contentType);
    APIsManager.logResponseBody(response);
    String token = APIsManager.getJsonStringValuefromResponse(response,"token");

    response = APIsManager.MakeRequest("Post",endpoint,map1,contentType);
    APIsManager.logResponseBody(response);
    int ID = APIsManager.getJsonIntValueFromResponse(response,"bookingid");

    map1.replace("firstname","Sayed");
    map1.replace("lastname","Mohamed");

    response = APIsManager.MakeAuthRequest("Put",endpoint+ID,map1,contentType,
            "CookieAuth",null,null,token);
    APIsManager.logResponseBody(response);

    response = APIsManager.MakeAuthRequest("Delete",endpoint+ID,null,null,
            "CookieAuth",null,null,token);
    APIsManager.logResponseBody(response);

    response= APIsManager.GetRequest(endpoint+ID,null);
    APIsManager.logResponseBody(response);
}

    @Test
    public void test10() throws ParseException {
        RestAssured.baseURI = "https://automationexercise.com/api/";

        String contentType = "application/x-www-form-urlencoded";
        String endpoint = "verifyLogin";
        Map map1 = new HashMap();
        map1.put("email","jmetwallym@gmail.com");
        map1.put("password","123456789");
    }



}
