package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Random;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(name = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;


    public void verifyWelcomeText(String text) {
        verifyThatTextIsDisplayed(welcomeText, text);
        CustomListeners.test.log(Status.PASS, "Verify Welcome Text  " + text);
    }

    public void randomEmailId() {
        emailField.click();
        Random randomEmail = new Random();
        int randomInt = randomEmail.nextInt(1000);
        emailField.sendKeys("username" + randomInt + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Select random Email  " );
    }
    public void enterEmailId(String text) {

        sendTextToElement(emailField, text);
        CustomListeners.test.log(Status.PASS, "Enter email " );
    }

    public void enterPassword(String password) {

        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " );
    }

    public void clickOnLoginButton() {

        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Clicking on Login Button " );
    }

    public void verifyErrorMessage(String text) {

        verifyThatTextIsDisplayed(errorMessage,text);
        CustomListeners.test.log(Status.PASS, "Verify error message  " + text);
    }
}