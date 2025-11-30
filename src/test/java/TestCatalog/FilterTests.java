package TestCatalog;
import Pages.HomePage;
import Pages.SearchResultsPage;
import org.example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTests extends BaseTest  {

    @Test(description = "Filters: Search in descriptions/subcategories affects results")
    public void filtersOnSearchCriteria_shouldImpactResults() {
        HomePage home = new HomePage();
        home.header().searchFor("Apple");
        SearchResultsPage results = new SearchResultsPage();
        int countBefore = results.productNames().size();

        results.toggleSearchInDescriptions(true);
        results.toggleSearchInSubcategories(true);
        results.applySearchFilters();

        int countAfter = results.productNames().size();

        Assert.assertTrue(countAfter >= 1, "Search results should refresh after applying filters.");
        Assert.assertTrue(countAfter != countBefore, "Results count should change after filters.");
    }
}
