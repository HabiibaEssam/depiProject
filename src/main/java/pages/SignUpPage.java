package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    WebDriverWait wait;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpFirstNameBox = By.cssSelector("#input-firstname");
    private By signUpLastNameBox = By.cssSelector("#input-lastname");
    private By signUpEmailBox = By.cssSelector("#input-email");
    private By signUpPasswordBox = By.cssSelector("#input-password");
    private By newsletterCheck = By.cssSelector("#input-newsletter");
    private By privacyPolicyCheck = By.xpath("(//input[@class=\"form-check-input\"])[2]");
    private By signUpContinueButton = By.cssSelector(".btn.btn-primary");

    public void insertSignUpFirstname (String firstname){

        driver.findElement(signUpFirstNameBox).sendKeys(firstname);
    }
    public void insertSignUpLastname (String lastname){

        driver.findElement(signUpLastNameBox).sendKeys(lastname);
    }
    public void insertSignUpEmail (String email){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signUpEmailBox));
        driver.findElement(signUpEmailBox).sendKeys(email);
    }
    public void insertSignUpPassword (String password){
        driver.findElement(signUpPasswordBox).sendKeys(password);
    }
    public void clickOnNewsletterCheck (){
        driver.findElement(newsletterCheck).click();
    }
    public void clickOnPrivacyPolicyCheck (){
        driver.findElement(privacyPolicyCheck).click();
    }

    public void clickOnSignUpButton (){
        driver.findElement(signUpContinueButton).click();
    }

}
