package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage {

    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    By sortDropdown = By.id("input-sort");
    By showDropdown = By.id("input-limit");
    By productNames = By.cssSelector("#product-list h4 a");

    public void openDesktopsPage() {
        driver.get("http://localhost/opencart/index.php?route=product/category&language=en-gb&path=20");
    }

    public void selectSortOption(String option) {
        WebElement sort = driver.findElement(sortDropdown);
        sort.click();
        List<WebElement> options = sort.findElements(By.tagName("option"));
        for (WebElement o : options) {
            if (o.getText().equals(option)) {
                o.click();
                break;
            }
        }
    }

    public void selectShowLimit(String limit) {
        WebElement show = driver.findElement(showDropdown);
        show.click();
        List<WebElement> options = show.findElements(By.tagName("option"));
        for (WebElement o : options) {
            if (o.getText().equals(limit)) {
                o.click();
                break;
            }
        }
    }

    public void verifySortAndShowOptions() {
        List<WebElement> products = driver.findElements(productNames);
        System.out.println("Products displayed:");
        for (WebElement p : products) {
            System.out.println(p.getText());
        }
    }
}
