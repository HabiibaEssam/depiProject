package org.example.ProductCatalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCategoryPage() {
        driver.get("http://localhost/opencart/index.php?route=product/category&path=20");
    }

    public void clickOnProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public boolean isProductDetailsVisible(String productName) {
        return driver.getPageSource().contains(productName);
    }
}