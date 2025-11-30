package StepDefinitions;


import org.example.ProductCatalog.ProductDetailsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetails_StepDef {
    WebDriver driver;
    ProductDetailsPage detailsPage;

    @Given("I am on the product catalog page")
    public void i_am_on_product_catalog_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.goToCategoryPage();
    }

    @When("I click on {string}")
    public void i_click_on(String productName) {
        detailsPage.clickOnProduct(productName);
    }

    @Then("I should see the product details page for {string}")
    public void i_should_see_product_details_for(String productName) {
        assert detailsPage.isProductDetailsVisible(productName);
        driver.quit();
    }
}