package testCases;

import baseTest.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;

import java.io.IOException;

public class AlertsTests extends CommonTests {
    String textInAlert = "I am a JS Alert";
    String resultTextAfterOkPressed = "You successfully clicked an alert";

    String textInConfirm = "I am a JS Confirm";
    String resultTextAfterConfirmPressed = "You clicked: Ok";
    String resultTextAfterDismissPressed = "You clicked: Cancel";

    String TextFromPrompt = "I am a JS prompt";
    String TextInPrompt = "I am Yehia Metwally";

    @Test
    public void verifyAcceptJSAlertButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                .clickOnAlertsPage()
                .clickOnJSAlertTriggerButton()
                .getTextInAlert()
                , textInAlert);

        Assert.assertEquals(
                new AlertsPage(driver)
                                .acceptAlert()
                                .getResultText()
                        , resultTextAfterOkPressed);
    }

    @Test
    public void verifyAcceptJSConfirmButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertConfirmButton()
                        .getTextInAlert()
                , textInConfirm);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .acceptAlert()
                        .getResultText()
                , resultTextAfterConfirmPressed);
    }

    @Test
    public void verifyCancelJSConfirmButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertConfirmButton()
                        .getTextInAlert()
                , textInConfirm);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .dismissAlert()
                        .getResultText()
                , resultTextAfterDismissPressed);
    }

    @Test
    public void verifyTypeOnJSPromptButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertPromptButton()
                        .getTextInAlert()
                , TextFromPrompt);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .typeTextInAlert(TextInPrompt)
                        .acceptAlert()
                        .getResultText()
                , "You entered: " + TextInPrompt);
    }
}

