package StepDefinitons;

import Home.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hook {
    static public WebDriver driver;
    public HomePage homePage;
    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        homePage = new HomePage(driver);
    }
    @After
    public void closeBroswer(){
        driver.quit();
    }
}
