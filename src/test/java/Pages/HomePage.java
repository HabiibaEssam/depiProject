package Pages;


import org.example.BasePageClass;
import org.example.components;
import org.openqa.selenium.By;

public class HomePage extends BasePageClass {
    private static final By Featured = By.cssSelector("product-thumb");

    public boolean isLoaded() {
        return !driver.findElements(Featured).isEmpty();
    }

    public components header() {
        return new components();
    }
}

