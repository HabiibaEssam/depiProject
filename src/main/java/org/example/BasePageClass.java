package org.example;


import DriverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePageClass {
    protected final WebDriver driver;
    protected final WaitUtils wait;

    protected BasePageClass() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WaitUtils(driver);
    }

    protected WebElement $(By locator) {
        return wait.visible(locator);
    }

    protected void click(By locator) {
        wait.clickable(locator).click();
    }

    protected void type(By locator, String text, boolean clearFirst) {
        WebElement el = $(locator);
        if (clearFirst) el.clear();
        el.sendKeys(text);
    }

    protected String text(By locator) {
        return $(locator).getText().trim();
    }
}

