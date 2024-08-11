package testCases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;

import java.io.IOException;

public class AlertsTests extends BaseTest {
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
                .getTheTextInAlert()
                , textInAlert);

        Assert.assertEquals(
                new AlertsPage(driver)
                                .acceptTheAlert()
                                .getTheResultText()
                        , resultTextAfterOkPressed);
    }

    @Test
    public void verifyAcceptJSConfirmButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertConfirmButton()
                        .getTheTextInAlert()
                , textInConfirm);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .acceptTheAlert()
                        .getTheResultText()
                , resultTextAfterConfirmPressed);
    }

    @Test
    public void verifyCancelJSConfirmButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertConfirmButton()
                        .getTheTextInAlert()
                , textInConfirm);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .dismissTheAlert()
                        .getTheResultText()
                , resultTextAfterDismissPressed);
    }

    @Test
    public void verifyTypeOnJSPromptButton() throws IOException {
        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnAlertsPage()
                        .clickOnJSAlertPromptButton()
                        .getTheTextInAlert()
                , TextFromPrompt);

        Assert.assertEquals(
                new AlertsPage(driver)
                        .typeTheTextInAlert(TextInPrompt)
                        .acceptTheAlert()
                        .getTheResultText()
                , "You entered: " + TextInPrompt);
    }
}

