package TestCatalog;


import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import org.example.BaseTest ;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTests extends BaseTest  {

    @Test(description = "Product details: open product and validate key UI elements")
    public void openProduct_validateDetailsAndAddToCart() {
        HomePage home = new HomePage();
        home.header().searchFor("iMac");
        SearchResultsPage results = new SearchResultsPage();

        ProductPage product = results.openFirstProduct();
        Assert.assertTrue(product.name().toLowerCase().contains("imac"), "Product name should be iMac.");
        Assert.assertTrue(product.hasDescriptionTab(), "Description tab should be present.");
        Assert.assertTrue(product.priceText().length() > 1, "Price should be visible.");
        product.addToCart();

    }
}

