package testCases;

import baseTest.CommonTests;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JDBC;
import utils.JsonFileReader;
import utils.TestDataGenerator;

import java.io.IOException;
import java.sql.SQLException;

@Epic("HerokuApp Functionalities")
@Feature("User Login")
@Story("Verify User Login on UI")
@Listeners(utils.TestNGListners.class)
public class LoginTests extends CommonTests {

    JsonFileReader jsonReader;
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/yehiadb1";
    String dbUser = "root";
    String dbPassword = "yehia";
    String dbQuery = "SELECT Username,Password,Massage FROM yehiadb1.usercredentials ORDER BY ID ASC";
    String jsonFilePath = "src/test/resources/TestDataJsonFiles/LoginCredentials.json";
    //JsonKeys shall be filled by the same order of table columns on database "always DESC"
    String[] jsonKeys = {"Username","Password","Massage"};
    //JsonMainKeys shall be filled by the same order of table rows on database
    String[] jsonMainKeys = {"ValidCredentials","InvalidPasswordCredentials",
            "InvalidUserCredentials"};

    @BeforeClass
    public void prepareTestData() throws IOException, ParseException, SQLException {
        JDBC.setJsonFileFromDB(dbUrl,dbUser,dbPassword, dbQuery, jsonFilePath,jsonKeys,jsonMainKeys);
        jsonReader = new JsonFileReader(jsonFilePath);
        jsonReader.setTestData("InvalidPasswordCredentials.Password"
                , TestDataGenerator.generateStrongPassword());
        jsonReader.setTestData("InvalidUserCredentials.Username"
                ,TestDataGenerator.generateName());
    }

    @Description("Successful Login With Valid Username And Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void SuccessfulLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("ValidCredentials.Username"))
                .setPassword(jsonReader.getTestData("ValidCredentials.Password"))
                .clickLoginButtonSuccess()
                .verifyWelcomeText(jsonReader.getTestData("ValidCredentials.Massage"));
    }

    @Description("Failed Login With Invalid Username And Valid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectUsernameLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("InvalidUserCredentials.Username"))
                .setPassword(jsonReader.getTestData("InvalidUserCredentials.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("InvalidUserCredentials.Massage"));
    }

    @Description("Failed Login With Valid Username And Invalid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectPasswordLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("InvalidPasswordCredentials.Username"))
                .setPassword(jsonReader.getTestData("InvalidPasswordCredentials.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("InvalidPasswordCredentials.Massage"));
    }
}
