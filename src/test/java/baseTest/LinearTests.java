package baseTest;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LinearTests {

    @Test
            public void test () throws IOException, ParseException {
        WebDriver driver = new EdgeDriver();
        Wait <WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);

        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        File filename = new File("src/test/resources/TestDataJsonFiles/LoginCredentials.json");
        //convert the json file to string
        String jsonString = FileUtils.readFileToString(filename,"UTF8");
        //parse the json string into object
        Object obj = new JSONParser().parse(jsonString);
        //return the object as Json Object
    }

}
