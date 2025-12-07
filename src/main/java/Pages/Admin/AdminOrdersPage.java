package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminOrdersPage {
    private final WebDriver driver;

    private final By viewBtn = By.cssSelector("a[data-original-title='View']");
    private final By orderStatusSelect = By.id("input-order-status");
    private final By addHistoryBtn = By.id("button-history");

    public AdminOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void viewFirstOrder() {
        driver.findElement(viewBtn).click();
    }

    public void changeOrderStatus(String statusVisibleText) {
        // open history block and set status:
        driver.findElement(orderStatusSelect).sendKeys(statusVisibleText);
        driver.findElement(addHistoryBtn).click();
    }
}

