package StepDefinitons;

import Home.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class CommonSteps {
    HomePage homepage;

    @Given("I am on the OpenCart home page")
    public void iAmOnTheOpenCartHomePage() {
        homepage = new HomePage(Hook.driver);
        String actualUrl = Hook.driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("opencart"),
                "Not on OpenCart homepage. Current URL: " + actualUrl);
    }

    @And("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = Hook.driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Page title doesn't contain '" + expectedTitle +
                        "'. Actual title: " + actualTitle);
    }
}
