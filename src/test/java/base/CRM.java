package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class CRM {

    @Test
    public void yehia() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        By usernameLocator = By.id("userNameInput");
        By passwordLocator = By.id("passwordInput");
        By signInButton = By.id("submitButton");
        By companyTab= By.id("sitemap-entity-ldv_SubArea");
        By newbutton= By.xpath("//button[@data-id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']");

        Wait<WebDriver> wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);

        driver.manage().window().maximize();
        driver.navigate().to("https://dtcmmarketingqa.dtcmdomain.com/main.aspx?appid=73db6562-3f24-ec11-9136-005056aedc84&forceUCI=1&pagetype=dashboard&id=ee50a18b-3f88-df11-8d93-00155db1891a&type=system&_canOverride=true");
        driver.findElement(usernameLocator).sendKeys("QACRMADMIN@dtcmuser.com");
        driver.findElement(passwordLocator).sendKeys("xnUXsg7!pa");
        driver.findElement(signInButton).click();

        wait.until(f->{
                driver.findElement(companyTab).click();
                return true;
                });

        wait.until(f->{
            driver.findElement(newbutton).click();
            return true;
        });

        wait.until(f->{
            By CompanyType=By.xpath("//select[@data-id='ldv_companybasetype.fieldControl-option-set-select']");
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CompanyType)));
            Select companyType = new Select(driver.findElement(CompanyType));
           companyType.selectByVisibleText("BA");
            return true;
        });

        wait.until(f->{
            By CompanyName=By.id("id-8448b78f-8f42-454e-8e2a-f8196b0419af-34-name-name.fieldControl-text-box-text");
            driver.findElement(CompanyName).sendKeys("YehiaCompany");
            return true;
        });

        wait.until(f->{
            By CompanyCategory=By.id("id-8448b78f-8f42-454e-8e2a-f8196b0419af-36-ldv_companycategorycode-ldv_companycategorycode.fieldControl-option-set-select");
            Select companyCategory = new Select(driver.findElement(CompanyCategory));
            companyCategory.selectByVisibleText("SME");
            return true;
        });

        wait.until(f->{
            By IndustrySectorPrimary=By.id("id-8448b78f-8f42-454e-8e2a-f8196b0419af-38-ldv_industrysectorprimarycode-ldv_industrysectorprimarycode.fieldControl-option-set-select");
            Select industrySectorPrimary = new Select(driver.findElement(IndustrySectorPrimary));
            industrySectorPrimary.selectByVisibleText("Automotive");
            return true;
        });

        wait.until(f->{
            By CompanyHQCity=By.id("id-8448b78f-8f42-454e-8e2a-f8196b0419af-49-ldv_companyhqlocationid-ldv_companyhqlocationid.fieldControl-LookupResultsDropdown_ldv_companyhqlocationid_1_textInputBox_with_filter_new");
            driver.findElement(CompanyHQCity).click();
            driver.findElement(CompanyHQCity).sendKeys("Albania",Keys.RETURN);
            driver.findElement(CompanyHQCity).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
            return true;
        });

        wait.until(f->{
            By AccountManager = By.id("id-8448b78f-8f42-454e-8e2a-f8196b0419af-76-ldv_accountmanager-ldv_accountmanager.fieldControl-LookupResultsDropdown_ldv_accountmanager_4_textInputBox_with_filter_new");
            driver.findElement(AccountManager).sendKeys("Business",Keys.RETURN,Keys.ARROW_DOWN,Keys.RETURN);
            return true;
        });
        wait.until(f->{
            By savebutton=By.xpath("//button[@data-id='account|NoRelationship|Form|Mscrm.Form.account.Save']");
            driver.findElement(savebutton).click();
            return true;
        });

    }



}
