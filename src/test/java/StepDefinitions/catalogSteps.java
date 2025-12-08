package StepDefinitions;

import Pages.CatalogPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class catalogSteps {

    WebDriver driver = Hooks.driver;
    CatalogPage catalogPage = new CatalogPage(driver);

    @Given("user is on the Desktops page")
    public void userIsOnTheDesktopsPage() {
        catalogPage.openDesktopsPage();
    }

    @When("user clicks on the sort dropdown and selects {string}")
    public void userSelectsSortOption(String sortOption) {
        catalogPage.selectSortOption(sortOption);
    }

    @When("user clicks on the show limit dropdown and selects {string}")
    public void userSelectsShowLimit(String limit) {
        catalogPage.selectShowLimit(limit);
    }

    @Then("user should see the products displayed according to the sort and show options")
    public void verifyProductsSortingAndLimit() {
        catalogPage.verifySortAndShowOptions();
    }
}
