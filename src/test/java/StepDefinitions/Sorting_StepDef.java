package StepDefinitions;

import org.example.ProductCatalog.SortingPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sorting_StepDef {
    WebDriver driver;
    SortingPage sortingPage;

    @Given("I am on the product catalog page")
    public void i_am_on_product_catalog_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sortingPage = new SortingPage(driver);
        sortingPage.goToCategoryPage();
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String optionText) {
        sortingPage.sortBy(optionText);
    }

    @Then("products should be displayed in ascending order of price")
    public void products_should_be_sorted_ascending() {
        assert sortingPage.isSortedAscending();
        driver.quit();
    }
}
