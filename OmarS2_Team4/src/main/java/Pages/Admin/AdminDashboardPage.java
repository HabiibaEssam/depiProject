package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminDashboardPage {

    WebDriver driver;

     By dashboardHeader = By.id("menu-dashboard");
     By catalogMenu = By.id("menu-catalog");
     By productsLink = By.xpath("//a[text()='Products']");
     By salesMenu = By.id("menu-sale");
     By ordersLink = By.xpath("//a[text()='Orders']");

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



