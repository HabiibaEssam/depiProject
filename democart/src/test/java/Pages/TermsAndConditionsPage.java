package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage {

    WebDriver driver;

    By pageHeading = By.cssSelector("h1");

    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }

}
