package CucumberstepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.LoginSubPage;

import java.io.IOException;

public class LoginSteps {
    //Dependency Injection
    BaseSteps basesteps;

    public LoginSteps(BaseSteps baseSteps)
    {
        this.basesteps = baseSteps;
    }

    //Variables
    String welcomeText = "Welcome to the Secure Area. When you are done click logout below.";
    String errorMassage = "Your email is invalid!\n×";

    @Given("User navigates to Login Page")
    public void user_navigates_to_login_page() throws IOException {
        basesteps.getWindowManager().navigateToURL(basesteps.url);
        new HomePage(basesteps.driver).clickOnLoginPage();
    }

    @When("User login with Valid Credentials {string} and {string}")
    public void user_login_with_valid_credentials(String username , String password) throws IOException {
        new LoginPage(basesteps.driver)
                .setUsername(username)
                .setPassword(password)
                .clickLoginButtonSuccess();
        basesteps.Username = username;
    }

    @Then("User can reach his homepage")
    public void user_can_reach_his_homepage() {
        new LoginSubPage(basesteps.driver).verifyWelcomeText(welcomeText);
    }

    @Then("User can print his Username")
    public void user_can_print_his_Username() {
        System.out.println(basesteps.Username);
    }

    @When("User login with Invalid Credentials {string} and {string}")
    public void user_login_with_invalid_credentials(String username, String password) throws IOException {
        new LoginPage(basesteps.driver)
                .setUsername(username)
                .setPassword(password)
                .clickLoginButtonFailure();
    }
    @Then("Error Massage shall be displayed")
    public void error_massage_shall_be_displayed() {
               new LoginPage(basesteps.driver).verifyErrorAlert(errorMassage);
    }
}
