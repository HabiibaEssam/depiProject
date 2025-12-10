package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    public static WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo3x.opencartreports.com/admin/");
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}

