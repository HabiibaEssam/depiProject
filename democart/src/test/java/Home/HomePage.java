package Home;

import Pages.TermsAndConditionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    //information
    By TermsConditionsLocator = By.linkText("Terms & Conditions");
    By DeliveryInformationLocator = By.linkText("Delivery Information");
    By AboutUsLocator = By.linkText("About Us");
    By PrivacyPolicyLocator = By.linkText("Privacy Policy");
    //Customer service
    By ContactUsLocator = By.linkText("Contact Us");
    By ReturnsLocator = By.linkText("Returns");
    By SiteMapLocator = By.linkText("Site Map");
    //Extra
    By BrandsLocator = By.linkText("Brands");
    By GiftCertificationsLocator = By.linkText("Gift Certificates");
    By AffiliateLocator = By.linkText("Affiliate");
    By SpecialsLocator = By.linkText("Specials");
    //Accounts very important
    By MyAccountLocator = By.linkText("My Account");
    By OrderHistoryLocator = By.linkText("Order History");
    By WishListLocator = By.linkText("Wish List");
    By NewsletterLocator = By.linkText("Newsletter");
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }
    //information pages
    public TermsAndConditionsPage clickTermsAndConditions() {
        driver.findElement(TermsConditionsLocator).click();
        return new TermsAndConditionsPage(driver);
    }
    public void clickDeliveryInformation(){
        driver.findElement(DeliveryInformationLocator).click();
    }
    public void clickAboutUs(){
        driver.findElement(AboutUsLocator).click();
    }

    public void clickPrivacyPolicy(){
        driver.findElement(PrivacyPolicyLocator).click();
    }
    //customer serv click
    public void clickContactUs() {
        driver.findElement(ContactUsLocator).click();
    }

    public void clickReturns(){
        driver.findElement(ReturnsLocator).click();
    }

    public void clickSiteMap(){
        driver.findElement(SiteMapLocator).click();
    }


    //Extras
    public void clickBrands(){
        driver.findElement(BrandsLocator).click();
    }

    public void clickGiftCertifications(){
        driver.findElement(GiftCertificationsLocator).click();
    }
    public void clickAffiliate(){
        driver.findElement(AffiliateLocator).click();
    }

    public void clickSpecials(){
        driver.findElement(SpecialsLocator).click();
    }
    //my account
    public void clickMyAccount() {
        driver.findElement(MyAccountLocator).click();
    }

    public void clickOrderHistory(){
        driver.findElement(OrderHistoryLocator).click();
    }

    public void clickWishList(){
        driver.findElement(WishListLocator).click();
    }

    public void clickNewsletter(){
        driver.findElement(NewsletterLocator).click();
    }











}
