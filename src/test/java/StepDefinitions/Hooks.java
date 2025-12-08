package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.time.Duration;

public class Hooks {
        public static WebDriver driver;

        @Before
        public void setUp() {
            driver = DriverFactory.getDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

        @After
        public void tearDown() {
            DriverFactory.quitDriver();
        }
    }

