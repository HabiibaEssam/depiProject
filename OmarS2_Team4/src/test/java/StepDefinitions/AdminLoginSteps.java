package StepDefinitions;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminLoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminLoginSteps {
    WebDriver driver = Hooks.getDriver();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
    AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

    @Given("Admin opens login page & press on login to login")
    public void adminlogin() {adminLoginPage.clickLogin();

    }

    @When("Admin enters valid email & password")
    public void login() {
        adminLoginPage.enterUsername("demo");
        adminLoginPage.enterPassword("demo");
    }

    @When("Admin submits login")
    public void adminClickOnLogin() {
        adminLoginPage.clickLogin();
    }
    @Then("Admin sees dashboard")
    public void adminSeesDashboard() {
        Assert.assertTrue(adminDashboardPage.isDashboardVisible(), "Dashboard should be visible after login");
    }
}