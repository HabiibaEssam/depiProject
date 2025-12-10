package StepDefinitons;

import Home.HomePage;
import Pages.DeliveryInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;

public class DeliveryInformationSteps {
    HomePage homepage= new HomePage(Hook.driver);;
    DeliveryInformationPage deliveryInfoPage;

//    @Given("I am on the OpenCart home page")
//    public void iAmOnTheOpenCartHomePage() {
//        homepage = new HomePage(Hook.driver);
//        String actualUrl = Hook.driver.getCurrentUrl();
//        Assert.assertTrue(actualUrl.contains("opencart.com"),
//                "Not on OpenCart homepage. Current URL: " + actualUrl);
//    }

    @When("I click on Delivery Information link")
    public void iClickOnDeliveryInformationLink() {
        deliveryInfoPage = homepage.clickDeliveryInformation();
    }

    @Then("I should be redirected to Delivery Information page")
    public void iShouldBeRedirectedToDeliveryInformationPage() {
        String actualUrl = Hook.driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("information/information&information_id=6"),
                "Not on Delivery Information page. Current URL: " + actualUrl);
    }

//    @And("the page title should contain {string}")
//    public void thePageTitleShouldContain(String expectedTitle) {
//        String actualTitle = Hook.driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectedTitle),
//                "Page title doesn't contain '" + expectedTitle +
//                        "'. Actual title: " + actualTitle);
//    }

    @Then("Delivery Information link should be visible")
    public void deliveryInformationLinkShouldBeVisible() {
        homepage = new HomePage(Hook.driver);
        Assert.assertTrue(homepage.isDeliveryInformationDisplayed(),
                "Delivery Information link is not visible");
    }

    @Then("the page heading should be {string}")
    public void thePageHeadingShouldBe(String expectedHeading) {
        String actualHeading = deliveryInfoPage.getPageHeading();
        Assert.assertEquals(actualHeading, expectedHeading,
                "Page heading doesn't match!");
    }
}
