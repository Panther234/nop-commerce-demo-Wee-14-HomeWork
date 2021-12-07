package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this); }

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;
    //    @FindBy(linkText = "Computers ")
//    WebElement computersMenuLink;
//
//    @FindBy(linkText = "Electronics ")
//    WebElement electronicsMenuLink;
//
//    @FindBy(linkText = "Apparel ")
//    WebElement apparelMenuLink;
//
//    @FindBy(linkText = "Digital downloads ")
//    WebElement digitalDownloadsMenuLink;
//
//    @FindBy(linkText = "Books ")
//    WebElement booksMenuLink;
//
//    @FindBy(linkText = "Jewelry ")
//    WebElement jewelryMenuLink;
//
//    @FindBy(linkText = "Gift Cards ")
//    WebElement giftCardsMenuLink;
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @FindBy(linkText = "My account")
    WebElement myAccountMenuLink;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class='header-menu']//li")
    WebElement allMenuList;

    public void selectMenu(String menu) {
      List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }

    public void clickOnLoginLink() {

        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Clicking on Login Link");
    }

    public void loginLinkDisplayed(){

        verifyThatElementIsDisplayed(loginLink);
        CustomListeners.test.log(Status.PASS, "Verifying displayed link ");
    }

    public void clickOnRegisterLink() {

        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Clicking on Register Link ");
    }

    public void clickOnMyAccountLink() {

        clickOnElement(myAccountMenuLink);
        CustomListeners.test.log(Status.PASS, "Clicking on MyAccount Link");
    }

    public void clickOnLogoutLink() {

        clickOnElement(logoutLink);
        CustomListeners.test.log(Status.PASS, "Clicking on Logout Link");
    }

    public void logoutLinkDisplayed(){

        verifyThatElementIsDisplayed(logoutLink);
        CustomListeners.test.log(Status.PASS, "Verify displayed Link");
    }

    public void verifyNopCommerceLogo() {

        verifyLogoDisplayed(nopCommerceLogo);
        CustomListeners.test.log(Status.PASS, "Verify Logo");
    }

}
