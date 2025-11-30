package StepDefinitons;

import Home.HomePage;
import Pages.TermsAndConditionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TermsAndConditonsSteps {

    TermsAndConditionsPage termsandConditonsPage;
    WebDriver driver = Hook.driver;
    HomePage homepage = new HomePage(driver);


    @Given("I am on the OpenCart home page")
    public void iAmOnTheOpenCartHomePage() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("opencart.com"),
                "Not on OpenCart homepage. Current URL: " + actualUrl);
    }

    @When("I click on Terms and Conditions link")
    public void iClickOnTermsAndConditionsLink() {
        termsandConditonsPage= homepage.clickTermsAndConditions();
    }

    @Then("I should be redirected to Terms and Conditions page")
    public void iShouldBeRedirectedToTermsAndConditionsPage() {
        String actualUrl = Hook.driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("information/terms"),
                "Not on Terms & Conditions page. Current URL: " + actualUrl);
    }

    @And("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = Hook.driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Page title doesn't contain '" + expectedTitle +
                        "'. Actual title: " + actualTitle);
    }

    @Then("Terms and Conditions link should be visible")
    public void termsAndConditionsLinkShouldBeVisible() {
        Assert.assertTrue(homepage.isTermsAndConditionsDisplayed(),
                "Terms and Conditions link is not visible");
    }
}
