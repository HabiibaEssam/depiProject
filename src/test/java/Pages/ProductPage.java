package Pages;


import org.example.BasePageClass;
import org.openqa.selenium.By;

public class ProductPage extends BasePageClass {
    private static final By PRODUCT_TITLE = By.cssSelector("h1");
    private static final By ADD_TO_CART = By.cssSelector("button-cart");
    private static final By TAB_DESCRIPTION = By.cssSelector("a[href='#tab-description']");
    private static final By TAB_SPECIFICATION = By.cssSelector("a[href='#tab-specification'], a[href='#tab-specs']");
    private static final By PRICE_BLOCK = By.cssSelector(".list-unstyled h2, .list-unstyled .price, .product-price");

    public String name() {
        return text(PRODUCT_TITLE);
    }

    public boolean hasDescriptionTab() {
        return !driver.findElements(TAB_DESCRIPTION).isEmpty();
    }

    public boolean hasSpecificationTab() {
        return !driver.findElements(TAB_SPECIFICATION).isEmpty();
    }

    public String priceText() {
        return text(PRICE_BLOCK);
    }

    public void addToCart() {
        click(ADD_TO_CART);
    }
}
