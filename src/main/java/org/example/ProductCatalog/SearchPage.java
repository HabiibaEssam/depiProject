package org.example.ProductCatalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.name("search");
    By searchButton = By.cssSelector("button.btn.btn-default");

    public void enterSearchTerm(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isProductVisible(String productName) {
        return driver.getPageSource().contains(productName);
    }

    public boolean isNoProductMessageVisible(String message) {
        return driver.getPageSource().contains(message);
    }
}
