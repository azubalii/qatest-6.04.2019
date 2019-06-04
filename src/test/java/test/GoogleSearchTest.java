package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleResultsPage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void googleSearchTest() {
        String searchTerm = "Selenium";
        int searchResultsNumber = 10;

        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Search page not loaded");

        GoogleResultsPage googleResultsPage1 = googleSearchPage.search(searchTerm);
        Assert.assertTrue(googleResultsPage1.isPageLoaded(), "Results page not loaded");

        Assert.assertEquals(googleResultsPage1.getSearchResultsCount(), searchResultsNumber);
        Assert.assertTrue(googleResultsPage1.isSearchTermPresent(searchTerm));

        GoogleResultsPage googleResultsPage2 = googleResultsPage1.getSecondResultsPage();
        Assert.assertTrue(googleResultsPage2.isPageLoaded());

        Assert.assertEquals(googleResultsPage2.getSearchResultsCount(), searchResultsNumber);
        Assert.assertTrue(googleResultsPage2.isSearchTermPresent(searchTerm));
    }
}
