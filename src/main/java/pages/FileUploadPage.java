package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ActionBot;

import java.io.IOException;

public class FileUploadPage {

    //Variables
    WebDriver driver;
    ActionBot bot;

    //Locators
    By chooseFileButton = By.id("file-upload");
    By uploadButton = By.id("file-submit");
    By successMassage= By.tagName("h3");
    By fileName = By.xpath("//div[@id='uploaded-files']");

    //Constructor
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        bot = new ActionBot(driver);
    }

    //Actions
    public FileUploadPage uploadFile(String filePath) throws IOException {
        bot.type(chooseFileButton,filePath);
        bot.press(uploadButton);
        return this;
    }

    public String getSuccessMassage() throws IOException {
        return bot.readText(successMassage);
    }

    public String getUploadedFileName() throws IOException {
        return bot.readText(fileName);
    }
}
