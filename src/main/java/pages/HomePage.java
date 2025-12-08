package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By myAccountTab = By.xpath("(//span[@class='d-none d-lg-inline'])[2]");
    private By registerDropDown = By.xpath("//a[@href=\"http://localhost/oc/index.php?route=account/register&language=en-gb\"]");
    private By loginDropDown = By.xpath("(//a[@class='dropdown-item'])[5]");
    private By logoutDropDown = By.xpath("(//a[@class=\"dropdown-item\"])[8]");

    public void clickOnMyAccountTab(){
        driver.findElement(myAccountTab).click();
    }
    public SignUpPage clickOnRegisterDropDown ()
    {
        driver.findElement(registerDropDown).click();
        return new SignUpPage(driver);
    }
    public LoginPage clickOnLoginDropDown (){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginDropDown));
        driver.findElement(loginDropDown).click();
        return new LoginPage(driver);
    }
    public void clickOnLogoutDropDown(){
        driver.findElement(logoutDropDown).click();
    }
}
