package testCases;

import baseTest.BaseTest;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.sql.SQLException;

import static utils.JDBC.*;
import static utils.TestDataGenerator.*;
import static utils.ThreadDriver.getIsolatedDriver;

import utils.JDBC;
import utils.JsonFileManager;

@Epic("HerokuApp Functionalities")
@Feature("User Login")
@Story("Verify User Login on UI")
@Listeners(utils.TestNGListners.class)
public class LoginTests extends BaseTest {

    JsonFileManager jsonReader;
    String dbQuery1 = "SELECT * FROM yehiadb1.usercredentials Order by ID ASC";
    String dbQuery2 = "SELECT * FROM yehiadb1.massages Order by ID ASC";
    String jsonFilePath = "src/test/resources/TestDataJsonFiles/LoginCredentials.json";
    //JsonKeys shall be filled by the same order of table columns on database "always DESC"
    String[] jsonKeys = {"Username","Password","ID"};
    //JsonMainKeys shall be filled by the same order of table rows on database
    String[] jsonMainKeys = {"FirstUser","SecondUser","ThirdUser"};
    String jsonMainKey = "Credentials";

    String[] jsonKeys2 = {"ID","MassageName","MassageValue"};

    String[] jsonMainKey2 = {"SuccessfulLogin","FailedLoginUsername","FailedLoginPassword"};

    @BeforeClass
    public void prepareTestData() throws IOException, ParseException, SQLException {
        jsonReader = new JsonFileManager(jsonFilePath);
        JSONObject obj1 = JDBC.setJsonObjectFromDBForNestedArrayOfJsonObjects(dbQuery1,jsonKeys,jsonMainKey);
        JSONObject obj2 = JDBC.setJsonObjectFromDBForNestedJsonObjects(dbQuery2,jsonKeys2,jsonMainKey2);
        JSONObject[] obj = {obj1, obj2};
        JDBC.setJsonFileFromMultipleJsonObjects(obj,jsonFilePath);
    }

    @Description("Successful Login With Valid Username And Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void SuccessfulLogin() throws IOException, ParseException {
        WebDriver driver = getIsolatedDriver(threadDriver);
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestDataInsideArray("Credentials[0].Username"))
                .setPassword(jsonReader.getTestDataInsideArray("Credentials[0].Password"))
                .clickLoginButtonSuccess()
                .verifyWelcomeText(jsonReader.getTestData("SuccessfulLogin.MassageValue"));
    }

    @Description("Failed Login With Invalid Username And Valid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectUsernameLogin() throws IOException, ParseException {
        WebDriver driver = getIsolatedDriver(threadDriver);
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("SecondUser.Username"))
                .setPassword(jsonReader.getTestData("SecondUser.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("SecondUser.ID"));
    }

    @Description("Failed Login With Valid Username And Invalid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectPasswordLogin() throws IOException, ParseException {
        WebDriver driver = getIsolatedDriver(threadDriver);
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("InvalidPasswordCredentials.Username"))
                .setPassword(jsonReader.getTestData("InvalidPasswordCredentials.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("InvalidPasswordCredentials.Massage"));
    }
}
