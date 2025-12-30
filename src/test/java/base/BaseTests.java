package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class BaseTests {
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    @BeforeClass
    public void setup (){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        goHome();
    }

    @BeforeMethod
    public void goHome (){
        driver.get("http://localhost/oc/");
    }

    @AfterClass
    public void quit (){
        driver.quit();
    }
}
