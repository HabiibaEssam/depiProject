
package DriverFactory;

import Configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static void initDriver() {
        String browser = Configuration.browser();
        boolean headless = Configuration.headless();

        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                if (headless) fo.addArguments("--headless=new");
                TL_DRIVER.set(new org.openqa.selenium.firefox.FirefoxDriver(fo));
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized");
                if (headless) co.addArguments("--headless=new", "--window-size=1920,1080");
                TL_DRIVER.set(new org.openqa.selenium.chrome.ChromeDriver(co));
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        WebDriver driver = TL_DRIVER.get();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        WebDriver d = TL_DRIVER.get();
        if (d == null) throw new IllegalStateException("Driver is not initialized. Call initDriver().");
        return d;
    }

    public static void quitDriver() {
        WebDriver d = TL_DRIVER.get();
        if (d != null) {
            d.quit();
            TL_DRIVER.remove();
        }
    }
}
