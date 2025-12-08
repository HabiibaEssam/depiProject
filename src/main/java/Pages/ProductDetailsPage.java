package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    WebDriver driver;

    @FindBy(css = "h1")
    WebElement productTitle;

    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @FindBy(id = "input-quantity")
    WebElement quantityInput;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void setQuantity(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }
}
