package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            WebDriverManager.chromedriver()
                    .driverVersion("142.0.7444.175")
                    .setup();

            ChromeOptions opts = new ChromeOptions();
            opts.addArguments("--start-maximized");
            opts.addArguments("--remote-allow-origins=*");

            driver.set(new ChromeDriver(opts));
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
