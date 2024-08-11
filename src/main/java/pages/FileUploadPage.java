package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;
import static utils.AlertsActions.*;
import static utils.BrowserOptions.*;
import static utils.CookiesManager.*;
import static utils.DropdownActions.*;
import static utils.JDBC.*;
import static utils.JsonFileWriter.*;
import static utils.Screenshot.*;
import static utils.ScrollActions.*;
import static utils.TestDataGenerator.*;
import static utils.Waits.*;
import static utils.WindowManager.*;

import java.io.IOException;

public class FileUploadPage {

    //Variables
    WebDriver driver;

    //Locators
    By chooseFileButton = By.id("file-upload");
    By uploadButton = By.id("file-submit");
    By successMassage= By.tagName("h3");
    By fileName = By.xpath("//div[@id='uploaded-files']");

    //Constructor
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public FileUploadPage uploadFile(String filePath) throws IOException {
        type(driver,chooseFileButton,filePath);
        press(driver,uploadButton);
        return this;
    }

    public String getSuccessMassage() throws IOException {
        return readText(driver,successMassage);
    }

    public String getUploadedFileName() throws IOException {
        return readText(driver,fileName);
    }
}
