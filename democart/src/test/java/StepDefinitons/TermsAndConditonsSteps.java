package StepDefinitons;

import Home.HomePage;
import Pages.TermsAndConditionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TermsAndConditonsSteps {

    TermsAndConditionsPage termsandConditonsPage;
    HomePage homepage = new HomePage(Hook.driver);

    @Given("I am on the OpenCart home page")
    public void iAmOnTheOpenCartHomePage() {
        Assert.assertEquals(Hook.driver.getCurrentUrl(), "https://demo.opencart.com/");
    }

    @When("I click on Terms and Conditions link")
    public void iClickOnTermsAndConditionsLink() {
        homepage.clickTermsAndConditions();
    }

    @Then("I should be redirected to Terms and Conditions page")
    public void iShouldBeRedirectedToTermsAndConditionsPage() {
        Assert.assertEquals(Hook.driver.getCurrentUrl(), "https://demo.opencart.com/en-gb/information/terms");
    }

    @And("the page title should contain {string}")
    public void thePageTitleShouldContain(String arg0) {
    }

    @Then("Terms and Conditions link should be visible")
    public void termsAndConditionsLinkShouldBeVisible() {
    }
}
