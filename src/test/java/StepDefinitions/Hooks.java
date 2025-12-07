package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

