package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends Utility {

    public ComputerPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computersPage;

    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopPageLink;

    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Notebooks']")
    WebElement notebooksPageLink;

    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Software']")
    WebElement softwarePageLink;


    public void verifyComputersText(String text) {

        verifyThatTextIsDisplayed(computersPage,text);
        CustomListeners.test.log(Status.PASS, "Computer text displayed " + text);

    }
    public void clickOnDesktopLink(){

        clickOnElement(desktopPageLink);
        CustomListeners.test.log(Status.PASS, "Click Desktop link ");
    }
    public void clickOnNotebookLink(){

        clickOnElement(notebooksPageLink);
        CustomListeners.test.log(Status.PASS, "Click Notebook Link");
    }
    public void clickOnSoftwareLink(){

        clickOnElement(softwarePageLink);
        CustomListeners.test.log(Status.PASS, "Click Software Link ");
    }
}
