package StepDefinitions;


import org.example.ProductCatalog.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_StepDef {
    WebDriver driver;
    SearchPage searchPage;

    @Given("I am on the home page")
    public void i_am_on_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/");
        searchPage = new SearchPage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String productName) {
        searchPage.enterSearchTerm(productName);
        searchPage.clickSearchButton();
    }

    @Then("I should see products related to {string}")
    public void i_should_see_products_related_to(String productName) {
        assert searchPage.isProductVisible(productName);
        driver.quit();
    }

    @Then("I should see {string}")
    public void i_should_see_message(String message) {
        assert searchPage.isNoProductMessageVisible(message);
        driver.quit();
    }
}