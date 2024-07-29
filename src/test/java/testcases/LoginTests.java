package testcases;

import base.CommonTests;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class LoginTests extends CommonTests {
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String welcomeText = "Welcome to the Secure Area. When you are done click logout below.";

    private String username2 = "yehiametwally";
    private String password2 = "nopassword";
    private String errorTextUsername = "Your username is invalid!\n" +
            "×";
    private String errorTextPassword = "Your password is invalid!\n" +
            "×";

    @Test
    public void SuccessfulLogin() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnLoginPage()
                        .setUsername(username)
                        .setPassword(password)
                        .clickLoginButtonSuccess()
                        .getWelcomeText()

                , welcomeText);
    }

    @Test
    public void IncorrectUsernameLogin() throws IOException {
        HomePage home = new HomePage(driver);
        Assert.assertEquals(
                home.clickOnLoginPage()
                        .setUsername(username2)
                        .setPassword(password2)
                        .clickLoginButtonFailure()
                        .getErrorAlert()

                , errorTextUsername);
    }

    @Test
    public void IncorrectPasswordLogin() throws IOException {
        HomePage home = new HomePage(driver);
        Assert.assertEquals(
                home.clickOnLoginPage()
                        .setUsername(username)
                        .setPassword(password2)
                        .clickLoginButtonFailure()
                        .getErrorAlert()

                , errorTextPassword);
    }

}
