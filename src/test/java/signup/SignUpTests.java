package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTests {
    @Test (priority = 1)
    public void register(){
        homePage.clickOnMyAccountTab();
        signUpPage = homePage.clickOnRegisterDropDown();
        signUpPage.insertSignUpFirstname("Mohamed");
        signUpPage.insertSignUpLastname("Hazem");
        signUpPage.insertSignUpEmail("hazem123123@gamil.com");
        signUpPage.insertSignUpPassword("123123");
        signUpPage.clickOnNewsletterCheck();
        signUpPage.clickOnPrivacyPolicyCheck();
        signUpPage.clickOnSignUpButton();
    }
}
