package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class components extends BasePageClass {

    // Search box in OpenCart header: input[name='search'] + button (default theme)
    private static final By SEARCH_INPUT = By.cssSelector("#search input[name='search']");
    private static final By SEARCH_BUTTON = By.cssSelector("#search button[type='button']");

    public void searchFor(String query) {
        type(SEARCH_INPUT, query, true);
        click(SEARCH_BUTTON);
        wait.waitUrlContains("route=product/search");
    }

    public String currentQuery() {
        WebElement input = $(SEARCH_INPUT);
        return input.getAttribute("value");
    }
}

