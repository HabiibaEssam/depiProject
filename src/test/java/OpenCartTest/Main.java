package OpenCartTest;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Main {

    @Test(priority = 0)
    public void openHomePage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://localhost/opencart/");
        System.out.println("Home Page opened successfully");

        driver.quit();
    }

    @Test(priority = 1)
    public void searchForMacbook() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://localhost/opencart/");

        WebElement searchInput = driver.findElement(By.cssSelector("search input[name='text']"));
        WebElement searchBtn = driver.findElement(By.cssSelector("search button[type='submit']"));

        searchInput.clear();
        searchInput.sendKeys("Macbook");
        searchBtn.click();

        String pageTitle = driver.findElement(By.cssSelector("control h1")).getText();
        System.out.println("Search page title: " + pageTitle);

        List<WebElement> cards = driver.findElements(By.cssSelector("Products meeting the search criteria"));
        System.out.println("Results found: " + cards.size());

        driver.quit();
    }

    @Test(priority = 2)
    public void searchForIphone() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://localhost/opencart/");

        WebElement searchInput = driver.findElement(By.cssSelector("search input[name='text']"));
        WebElement searchBtn = driver.findElement(By.cssSelector("search button[type='submit']"));

        searchInput.clear();
        searchInput.sendKeys("iPhone");
        searchBtn.click();

        String pageTitle = driver.findElement(By.cssSelector("content h1")).getText();
        System.out.println(" Search page title: " + pageTitle);

        List<WebElement> cards = driver.findElements(By.cssSelector("Products meeting the search criteria"));
        System.out.println("Results found: " + cards.size());

        driver.quit();
    }
}