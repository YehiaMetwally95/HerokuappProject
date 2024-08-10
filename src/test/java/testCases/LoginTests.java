package testCases;

import baseTest.CommonTests;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JsonFileReader;

import java.io.IOException;

@Epic("HerokuApp Functionalities")
@Feature("User Login")
@Story("Verify User Login on UI")
@Listeners(utils.TestNGListners.class)
public class LoginTests extends CommonTests {

    JsonFileReader jsonReader;

    @BeforeClass
    public void prepareTestData() {
        String filePath = "src/test/resources/TestDataJsonFiles/LoginCredentials.json";
        jsonReader = new JsonFileReader(filePath);
    }

    @Description("Successful Login With Valid Username And Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void SuccessfulLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("SuccessfulLogin.Username"))
                .setPassword(jsonReader.getTestData("SuccessfulLogin.Password"))
                .clickLoginButtonSuccess()
                .verifyWelcomeText(jsonReader.getTestData("SuccessfulLogin.WelcomeText"));
    }

    @Description("Failed Login With Invalid Username And Valid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectUsernameLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("IncorrectUserLogin.Username"))
                .setPassword(jsonReader.getTestData("IncorrectUserLogin.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("IncorrectUserLogin.ErrorMassage"));
    }

    @Description("Failed Login With Valid Username And Invalid Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void IncorrectPasswordLogin() throws IOException, ParseException {
        new HomePage(driver)
                .clickOnLoginPage()
                .setUsername(jsonReader.getTestData("IncorrectPasswordLogin.Username"))
                .setPassword(jsonReader.getTestData("IncorrectPasswordLogin.Password"))
                .clickLoginButtonFailure()
                .verifyErrorAlert(jsonReader.getTestData("IncorrectPasswordLogin.ErrorMassage"));
    }
}
