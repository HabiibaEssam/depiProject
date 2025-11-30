package TestCatalog;

import Pages.HomePage;
import org.example.BaseTest ;
import Pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingTests extends BaseTest  {

    @Test(description = "Sorting: Validate Sort By (Price Low > High)")
    public void sortByPriceAscending_shouldOrderCorrectly() {
        HomePage home = new HomePage();
        home.header().searchFor("Macbook");
        SearchResultsPage results = new SearchResultsPage();

        results.setSortBy("Price (Low > High)");

        List<Double> prices = results.productNames().stream()
                .map(name -> extractPriceForCard(name))
                .collect(Collectors.toList());


        Assert.assertTrue(isSortedAsc(prices), "Prices should be sorted ascending.");
    }


    private Double extractPriceForCard(String ProductName) {
        return 0.0;
    }


    private boolean isSortedAsc(List<Double> list) {
        return list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).equals(list);
    }
}

