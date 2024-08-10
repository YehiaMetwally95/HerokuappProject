package testCases;

import baseTest.CommonTests;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class ScrollTests extends CommonTests {

    @Test
    private void scrollToTable() throws IOException {
        new HomePage(driver).clickOnLargeAndDeemDom().scrollDownToTable();
    }

    @Test
    private void scrollByGivenAmountFromHeader() throws IOException {
        new HomePage(driver)
                .clickOnLargeAndDeemDom()
                .scrollByGivenAmountFromHeader(100,100);
    }

    @Test
    private void scrollByGivenAmountFromFooter() throws IOException {
        new HomePage(driver)
                .clickOnLargeAndDeemDom()
                .scrollDownToFooter()
                .scrollByGivenAmountFromFooter(100,-100);
    }

    @Test
    private void scrollDownToTargetParagraph() throws IOException {
        new HomePage(driver)
                .clickOnInfiniteScroll()
                .scrollDownToTenthParagraph();
    }
}
