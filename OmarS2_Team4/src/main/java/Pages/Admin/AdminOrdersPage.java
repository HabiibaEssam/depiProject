package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminOrdersPage {
    WebDriver driver;

    public AdminOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By viewBtn =By.cssSelector("a[data-original-title='View']");
    private By orderStatusSelect =By.id("input-order-status");
    private By addHistoryBtn =By.id("button-history");

    public void viewFirstOrder() {
        driver.findElement(viewBtn).click();
    }

    public void changeOrderStatus(String statusVisibleText) {
        // open history block and set status:
        driver.findElement(orderStatusSelect).sendKeys(statusVisibleText);
        driver.findElement(addHistoryBtn).click();
    }

}


