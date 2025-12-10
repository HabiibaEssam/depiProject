package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryInformationPage {

    WebDriver driver;

    private By pageHeading = By.xpath("//h1[contains(text(),'Delivery Information')]");

    public DeliveryInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isOnDeliveryInformationPage() {
        return getCurrentUrl().contains("information/delivery");
    }


}
