package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import Pages.ProductDetailsPage;


public class ProductDetailsSteps {
    WebDriver driver = Hooks.driver;
    ProductDetailsPage pdPage = new ProductDetailsPage(driver);

    @Given("I am on the Product Details Page for \"iMac\"")
    public void i_am_on_product_details_page() {
        driver.get("http://localhost/opencart/index.php?route=product/product&language=en-gb&product_id=41");
        pdPage = new ProductDetailsPage(driver);
    }

    @Then("I see the product details for {string}")
    public void i_see_the_product_details_for(String expectedName) {
        String actualName = pdPage.getProductTitle();
        if (!actualName.equals(expectedName)) {
            throw new AssertionError("Expected: " + expectedName + " but found: " + actualName);
        }
    }

    @When("I add {string} quantity to cart")
    public void i_add_quantity_to_cart(String qty) {
        pdPage.setQuantity(qty);
        pdPage.clickAddToCart();
    }
}