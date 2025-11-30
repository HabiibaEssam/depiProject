package TestCatalog;

import Pages.HomePage;
import org.example.BaseTest ;
import Pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest  {

    @Test(description = "Search: basic query should return relevant results")
    public void ensureSearchForMacbookReturnsRelevantProducts() {

        final String query = "Macbook";
        HomePage home = new HomePage();
        Assert.assertTrue(home.isLoaded(), "Home page should be loaded before searching.");


        home.header().searchFor(query);
        SearchResultsPage results = new SearchResultsPage();


        String title = results.title();
        String titleLower = title.toLowerCase();
        Assert.assertTrue(titleLower.contains("search"),
                "Expected page title to include 'Search' but was: '" + title + "'");
        Assert.assertTrue(titleLower.contains(query.toLowerCase()),
                "Expected page title to include query '" + query + "' but was: '" + title + "'");


        List<String> names = results.productNames();
        Assert.assertTrue(names != null, "Product names list should not be null.");
        Assert.assertFalse(names.isEmpty(),
                "Search results should not be empty for query '" + query + "'.");


        boolean anyMatch = names.stream()
                .map(String::toLowerCase)
                .anyMatch(n -> n.contains(query.toLowerCase()));
        Assert.assertTrue(anyMatch,
                "Expected at least one product name to contain '" + query + "'. Actual: " + names);
    }
}

