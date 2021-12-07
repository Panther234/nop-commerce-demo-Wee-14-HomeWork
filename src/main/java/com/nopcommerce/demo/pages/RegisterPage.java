package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Utility {

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerPageText;

    @FindBy(xpath = "//div[@id='gender']")
    WebElement genderSelector;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordBox;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickRegisterButton;

    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompletedText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameRequiredError;

    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameRequiredError;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthOfBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearOfBirthYear;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailRequiredError;

    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordRequiredError;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPasswordRequiredError;

    public void verifyRegisterPageText(String text) {

        verifyThatTextIsDisplayed(registerPageText, text);
        CustomListeners.test.log(Status.PASS, "Verify Register Page Text  " + text);
    }

    public void selectGender(String text) {

        clickOnElement(genderSelector, text);
        CustomListeners.test.log(Status.PASS, "Select Gender " + text);
    }

    public void firstNameClick(String text) {

        sendTextToElement(firstNameBox, text);
        CustomListeners.test.log(Status.PASS, "First name  " + text);
    }

    public void lastNameClick(String text) {

        sendTextToElement(lastNameBox, text);
        CustomListeners.test.log(Status.PASS, "Last name " + text);
    }

    public void selectDateOfBirth(String dayDOB, String monthDOB, String yeaDOB) {

        selectByVisibleTextFromDropDown(dateOfBirthDay, dayDOB);
        selectByVisibleTextFromDropDown(monthOfBirthMonth, monthDOB);
        selectByVisibleTextFromDropDown(yearOfBirthYear, yeaDOB);
        CustomListeners.test.log(Status.PASS, "Birth details  " );
    }

    public void enterEmailId(String text) {

        sendTextToElement(emailBox, text);
        CustomListeners.test.log(Status.PASS, "Enter Email  " + text);
    }

    public void passwordClick(String text) {

        sendTextToElement(passwordBox, text);
        CustomListeners.test.log(Status.PASS, "Enter password  " + text);
    }

    public void confirmPasswordClick(String text) {

        sendTextToElement(confirmPasswordBox, text);
        CustomListeners.test.log(Status.PASS, "Enter confirmPassword " + text);
    }

    public void registerButtonClick() {

        clickOnElement(clickRegisterButton);
        CustomListeners.test.log(Status.PASS, "Click Register Button " );
    }

    public void verifyRegisterText(String text) {

        verifyThatTextIsDisplayed(registrationCompletedText, text);
        CustomListeners.test.log(Status.PASS, "Click Register Button" + text);
    }

    public void clickContinueButton() {

        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click Continue Button" );
    }

    public void verifyFirstNameErrorMessage(String text) {

        verifyThatTextIsDisplayed(firstNameRequiredError, text);
        CustomListeners.test.log(Status.PASS, "First name error " + text);
    }

    public void verifyLastNameErrorMessage(String text) {

        verifyThatTextIsDisplayed(lastNameRequiredError, text);
        CustomListeners.test.log(Status.PASS, "Last name error " + text);
    }

    public void verifyEmailErrorMessage(String text) {

        verifyThatTextIsDisplayed(emailRequiredError, text);
        CustomListeners.test.log(Status.PASS, "Email error " + text);
    }

    public void verifyPasswordErrorMessage(String text) {

        verifyThatTextIsDisplayed(passwordRequiredError, text);
        CustomListeners.test.log(Status.PASS, "Password error " + text);
    }

    public void verifyConfirmPasswordErrorMessage(String text) {

        verifyThatTextIsDisplayed(confirmPasswordRequiredError, text);
        CustomListeners.test.log(Status.PASS, "Confirm password error  " + text);
    }


}
