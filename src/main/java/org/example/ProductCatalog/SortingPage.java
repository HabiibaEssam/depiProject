package org.example.ProductCatalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class SortingPage {
    WebDriver driver;

    public SortingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCategoryPage() {
        driver.get("http://localhost/opencart/index.php?route=product/category&path=20");
    }

    public void sortBy(String optionText) {
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        sortDropdown.sendKeys(optionText);
    }

    public boolean isSortedAscending() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".price"));
        List<Double> prices = new ArrayList<>();
        for (WebElement price : priceElements) {
            String text = price.getText().replace("$", "").replace(",", "").trim();
            try {
                prices.add(Double.parseDouble(text));
            } catch (NumberFormatException ignored) {}
        }
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        return prices.equals(sorted);
    }
}