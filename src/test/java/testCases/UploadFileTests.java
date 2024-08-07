package testCases;

import baseTest.CommonTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

import java.io.IOException;

public class UploadFileTests extends CommonTests {

    String filePath = System.getProperty("user.dir") + "/src/test/resources/TestFiles/Mattresses.pdf";
    String successMassage = "File Uploaded!";
    String fileName = "Mattresse.pdf";

    @Test
    public void UploadFile() throws IOException {

        Assert.assertEquals(
                new HomePage(driver)
                        .clickOnFileUploadPage()
                        .uploadFile(filePath)
                        .getSuccessMassage()
                , successMassage
        );

        Assert.assertEquals(
                new FileUploadPage(driver)
                        .getUploadedFileName()
                , fileName
        );
    }
}
