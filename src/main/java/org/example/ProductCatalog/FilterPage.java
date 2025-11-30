package org.example.ProductCatalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPage {
    WebDriver driver;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCategoryPage() {
        driver.get("http://localhost/opencart/index.php?route=product/category&path=20");
    }

    public void filterByCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }

    public boolean isCategoryVisible(String categoryName) {
        return driver.getPageSource().contains(categoryName);
    }
}