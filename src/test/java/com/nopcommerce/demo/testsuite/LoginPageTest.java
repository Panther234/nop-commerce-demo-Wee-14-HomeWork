package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText("Welcome, Please Sign In!");
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.randomEmailId();
        loginPage.enterPassword("Bob1234");
        loginPage.clickOnLoginButton();
        loginPage.verifyErrorMessage("Login was unsuccessful. Please correct the errors and try again.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("bob@gmail.com");
        loginPage.enterPassword("Bob1234");
        loginPage.clickOnLoginButton();
        homePage.logoutLinkDisplayed();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("bob@gmail.com");
        loginPage.enterPassword("Bob1234");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogoutLink();
        homePage.loginLinkDisplayed();
    }
}
