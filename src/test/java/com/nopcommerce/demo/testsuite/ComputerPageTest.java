package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.verifyComputersText("Computers");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.clickOnDesktopLink();
        desktopsPage.verifyDesktopText("Desktops");
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class, groups = {"regression"})
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        homePage.selectMenu("Computers");
        computerPage.clickOnDesktopLink();
        desktopsPage.productFromDesktopPage("Build your own computer");
        buildYourOwnComputerPage.selectParts(processor,ram,hdd,os,software);
        buildYourOwnComputerPage.clickAddToCart();
        buildYourOwnComputerPage.verifyAddToCartText();
    }

}
