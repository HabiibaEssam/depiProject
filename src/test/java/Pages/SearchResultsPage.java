package Pages;

import org.example.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePageClass {

    private static final By PAGE_TITLE = By.cssSelector("content h1");
    private static final By PRODUCT_CARD =By.xpath("//div[contains(@class,'product-thumb')]");
    private static final By PRODUCT_NAME_IN_CARD = By.cssSelector("product thumb h4 a");
    private static final By PRODUCT_PRICE_IN_CARD = By.cssSelector("product thumb .price");
    private static final By SORT_DROPDOWN = By.cssSelector("select input-sort");
    private static final By SHOW_DROPDOWN = By.cssSelector("select input-limit");


    private static final By SEARCH_IN_DESCRIPTIONS = By.cssSelector("input[name='description']");
    private static final By SEARCH_IN_SUBCATEGORIES = By.cssSelector("input[name='sub_category']");
    private static final By FILTER_SEARCH_BUTTON = By.cssSelector("content input[type='button'][value='Search']");

    public String title() {
        return text(PAGE_TITLE);
    }


    public List<String> productNames() {
        List<String> names = new ArrayList<>();
        for (WebElement card : driver.findElements(PRODUCT_CARD)) {
            names.add(card.findElement(PRODUCT_NAME_IN_CARD).getText().trim());
        }
        return names;
    }

    public void setSortBy(String visibleText) {
        selectByVisibleText(SORT_DROPDOWN, visibleText);
    }

    public void setShowLimit(String visibleText) {
        selectByVisibleText(SHOW_DROPDOWN, visibleText);
    }

    public void toggleSearchInDescriptions(boolean enable) {
        setCheckbox(SEARCH_IN_DESCRIPTIONS, enable);
    }

    public void toggleSearchInSubcategories(boolean enable) {
        setCheckbox(SEARCH_IN_SUBCATEGORIES, enable);
    }

    public void applySearchFilters() {
        click(FILTER_SEARCH_BUTTON);
        wait.waitUrlContains("route=product/search");
    }

    private void selectByVisibleText(By selectLocator, String visibleText) {
        WebElement dd = $(selectLocator);
        new org.openqa.selenium.support.ui.Select(dd).selectByVisibleText(visibleText);
    }

    private void setCheckbox(By locator, boolean enable) {
        WebElement cb = $(locator);
        if (cb.isSelected() != enable) cb.click();
    }

    public ProductPage openFirstProduct() {
        WebElement first = $(PRODUCT_CARD);
        wait.safeScrollIntoView(first);
        first.findElement(PRODUCT_NAME_IN_CARD).click();
        return new ProductPage();
    }
}

