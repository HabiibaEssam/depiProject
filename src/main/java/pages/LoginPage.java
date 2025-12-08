package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginEmailBox = By.cssSelector("#input-email");
    private By loginPasswordBox = By.cssSelector("#input-password");
    private By loginButton = By.xpath("//button[@class=\"btn btn-primary\"]");

    public void insertLoginEmail (String username){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginEmailBox));
        driver.findElement(loginEmailBox).sendKeys(username);
    }
    public void insertLoginPassword (String password){
        driver.findElement(loginPasswordBox).sendKeys(password);
    }
    public void clickOnLoginButton (){
        driver.findElement(loginButton).click();
    }

}
