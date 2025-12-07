package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
    private final WebDriver driver;

    private final By dashboardHeader = By.xpath("//h1[contains(.,'Dashboard')]");
    private final By catalogMenu = By.id("menu-catalog");
    private final By productsLink = By.xpath("//a[text()='Products']");
    private final By salesMenu = By.id("menu-sale");
    private final By ordersLink = By.xpath("//a[text()='Orders']");

    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public void goToProducts() {
        driver.findElement(catalogMenu).click();
        driver.findElement(productsLink).click();
    }

    public void goToOrders() {
        driver.findElement(salesMenu).click();
        driver.findElement(ordersLink).click();
    }
}

