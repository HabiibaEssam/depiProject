package org.example;


import DriverFactory.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import Configuration.Configuration;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUpSuite() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(Configuration.baseUrl());
    }

    @AfterClass
    public void tearDownSuite() {
        DriverFactory.quitDriver();
    }
}
