package StepDefinitions;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import Pages.SearchPage;

public class SearchSteps {

    WebDriver driver;
    SearchPage searchPage;

    public SearchSteps() {
        this.driver = Hooks.driver;
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        driver.get("http://localhost/opencart/index.php?route=common/home&language=en-gb");
        searchPage = new SearchPage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        searchPage.enterSearch(product);
        searchPage.clickSearch();
    }

    @Then("I should see search results containing {string}")
    public void i_should_see_search_results(String product) {
        assertTrue(searchPage.isProductFound(product));
    }

    @And("I click on the searched product {string}")
    public void i_click_on_the_product(String product) {
        searchPage.clickOnProduct(product);
    }

    @And("I should be on the product page of {string}")
    public void i_am_on_the_product_page(String product) {
        String title = driver.getTitle();
        assertTrue(title != null && title.contains(product));
    }

    @Then("I should see a message that no products were found")
    public void i_should_see_no_results() {
        assertTrue(searchPage.isNoResultsDisplayed());
    }
}
