package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildYourOwnComputerPage extends Utility {

    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputerText;

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorSelect;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramSelect;

    @FindBy(xpath = "//input[@name='product_attribute_3']")
    WebElement hddSelect;

    @FindBy(xpath = "//input[@name= 'product_attribute_4']")
    WebElement operatingSystemSelect;

    @FindBy(xpath = "//input[@name= 'product_attribute_5']")
    WebElement softwareSelect;

    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCartSelect;

    @FindBy(xpath = "//p[contains(.,'The product has been added to your shopping cart')]")
    WebElement productAddToCartText;


    public void verifyBuildYourOwnComputerText() {

        verifyThatTextIsDisplayed(buildYourOwnComputerText, "Build your own computer");
        CustomListeners.test.log(Status.PASS, "Build your own computer text displayed ");
    }

    public void selectProcessorFromDropDown(String text) {

        selectByVisibleTextFromDropDown(processorSelect, text);
        CustomListeners.test.log(Status.PASS, "Select Processor " + text);
    }

    public void selectRAMFromDropDown(String text) {

        selectByVisibleTextFromDropDown(ramSelect, text);
        CustomListeners.test.log(Status.PASS, "Select RAM " + text);
    }

    public void selectHDDRadioButton(String text) {

        clickOnElement(hddSelect, text);
        CustomListeners.test.log(Status.PASS, "Select Harddisk " + text);
    }

    public void selectOSRadioButton(String text) {

        clickOnElement(operatingSystemSelect, text);
        CustomListeners.test.log(Status.PASS, "Select Operating system " + text);
    }

    public void selectSoftwareCheckBox(String text) {

        clickOnElement(softwareSelect, text);
        CustomListeners.test.log(Status.PASS, "Select Software " + text);
    }

    public void clickAddToCart() {

        clickOnElement(addToCartSelect);
        CustomListeners.test.log(Status.PASS, "Add to cart ");
    }

    public void verifyAddToCartText() {

        verifyThatTextIsDisplayed(productAddToCartText, "The product has been added to your shopping cart");
        CustomListeners.test.log(Status.PASS, "Verify Add to cart ");
    }

    public void selectParts(String processor, String ram, String hdd, String os, String software) {
        selectProcessorFromDropDown(processor);
        selectRAMFromDropDown(ram);
        selectHDDRadioButton(hdd);
        selectOSRadioButton(os);
        selectSoftwareCheckBox(software);
    }


}
