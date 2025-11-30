package StepDefinitions;

import org.example.ProductCatalog.FilterPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filter_StepDef {
    WebDriver driver;
    FilterPage filterPage;

    @Given("I am on the product catalog page")
    public void i_am_on_product_catalog_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        filterPage = new FilterPage(driver);
        filterPage.goToCategoryPage();
    }

    @When("I filter by {string}")
    public void i_filter_by(String categoryName) {
        filterPage.filterByCategory(categoryName);
    }

    @Then("I should see only products in {string}")
    public void i_should_see_only_products_in(String categoryName) {
        assert filterPage.isCategoryVisible(categoryName);
        driver.quit();
    }
}