package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminLoginPage {
    WebDriver driver;

    public AdminLoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By username =By.id("input-username");
    private By password =By.id("input-password");
    private By loginButton =By.cssSelector("button[type='submit']");

    public void enterUsername (String user){
        driver.findElement(username);
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword (String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void login(String username,String password){
        driver.findElement(By.id("input-username")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}