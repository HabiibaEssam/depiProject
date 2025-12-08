package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test(priority = 1)
    public void login() {
        homePage.clickOnMyAccountTab();
        loginPage = homePage.clickOnLoginDropDown();
        loginPage.insertLoginEmail("hazem123123@gamil.com");
        loginPage.insertLoginPassword("123123");
        loginPage.clickOnLoginButton();
    }
    @Test(priority = 2)
    public void logout() throws InterruptedException{
        homePage.clickOnMyAccountTab();
        loginPage = homePage.clickOnLoginDropDown();
        loginPage.insertLoginEmail("hazem123123@gamil.com");
        loginPage.insertLoginPassword("123123");
        loginPage.clickOnLoginButton();
        homePage.clickOnMyAccountTab();
        homePage.clickOnLogoutDropDown();
    }
}

