package StepDefinitions;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminLoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class AdminLoginSteps {

    private final AdminLoginPage loginPage;
    private final AdminDashboardPage dashboard;

    public AdminLoginSteps() {
        this.loginPage = new AdminLoginPage(Hooks.driver);
        this.dashboard = new AdminDashboardPage(Hooks.driver);
    }

    @Given("admin opens admin login page")
    public void admin_opens_admin_login_page() {
        loginPage.open("https://demo.opencart.com/admin/");
    }

    @When("admin provides valid credentials")
    public void admin_provides_valid_credentials() {
        loginPage.enterUsername("demo");
        loginPage.enterPassword("demo");
    }

    @When("admin submits login")
    public void admin_submits_login() {
        loginPage.clickLogin();
    }

    @Then("admin sees the dashboard")
    public void admin_sees_the_dashboard() {
        Assert.assertTrue(dashboard.isDashboardVisible(), "Dashboard should be visible after login");
    }
}

