package CucumberClassRunner;

import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles"
        , glue = "CucumberstepDefinitions"
        , plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
}
