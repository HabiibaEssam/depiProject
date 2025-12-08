package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    @FindBy(name = "search")
    WebElement searchInput;

    @FindBy(css = ".btn.btn-light")
    WebElement searchButton;

    @FindBy(css = "#product-list .product-thumb h4 a")
    List<WebElement> productResults;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearch(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isProductFound(String productName) {
        return productResults.stream().anyMatch(e -> e.getText().contains(productName));
    }

    public void clickOnProduct(String productName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement product : productResults) {
            if (product.getText().contains(productName)) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);


                wait.until(ExpectedConditions.elementToBeClickable(product));


                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);

                break;
            }
        }
    }


    public boolean isNoResultsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content p"))
        );

        return msg.getText().contains("There is no product that matches the search criteria.");
    }


}
