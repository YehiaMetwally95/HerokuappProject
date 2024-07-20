package testcases;

import base.CommonTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WindowManager;

public class ScrollTests extends CommonTests {

    @Test
    private void scrollToTable()
    {
        new HomePage(driver).clickOnLargeAndDeemDom().scrollDownToTable();
    }

    @Test
    private void scrollByGivenAmountFromHeader()
    {
        new HomePage(driver)
                .clickOnLargeAndDeemDom()
                .scrollByGivenAmountFromHeader(100,100);
    }

    @Test
    private void scrollByGivenAmountFromFooter()
    {
        new HomePage(driver)
                .clickOnLargeAndDeemDom()
                .scrollDownToFooter()
                .scrollByGivenAmountFromFooter(100,-100);
    }

    @Test
    private void scrollDownToTargetParagraph()
    {
        new HomePage(driver)
                .clickOnInfiniteScroll()
                .scrollDownToFifthParagraph();
    }
}
