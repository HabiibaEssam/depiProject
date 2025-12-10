package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminProductsPage {
    WebDriver driver;

    public AdminProductsPage(WebDriver driver){
        this.driver = driver;
    }

     By addBtn = By.cssSelector("a[data-original-title='Add New']");
     By productNameField = By.id("input-name1");
     By metaTitleField = By.id("input-meta-title1");
     By dataTab = By.linkText("Data");
     By modelField = By.id("input-model");
     By saveBtn = By.cssSelector("button[data-original-title='Save']");

     By checkboxAll = By.name("selected[]");
     By editBtn = By.cssSelector("a[data-original-title='Edit']");
     By deleteBtn = By.cssSelector("button[data-original-title='Delete']");



    public void clickAdd() {
        driver.findElement(addBtn).click();
    }

    public void createProduct(String name, String meta, String model) {
        driver.findElement(productNameField).sendKeys(name);
        driver.findElement(metaTitleField).sendKeys(meta);
        driver.findElement(dataTab).click();
        driver.findElement(modelField).sendKeys(model);
        driver.findElement(saveBtn).click();
    }


    public boolean hasProductsList() {
        List<WebElement> list = driver.findElements(checkboxAll);
        return list.size() > 0;
        }

    public void selectFirstProduct() {
        List<WebElement> list = driver.findElements(checkboxAll);
        if (!list.isEmpty()) {
            list.get(0).click();
        }
    }

    public void clickDeleteAndAccept() {
        driver.findElement(deleteBtn).click();
        // Accept JS alert
        driver.switchTo().alert().accept();
    }


}


