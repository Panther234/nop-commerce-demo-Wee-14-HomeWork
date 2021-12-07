package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Utility {
    public DesktopsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopText;

    @FindBy(xpath ="//select[@id='products-orderby']")
    WebElement sortBy;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement displayBy;

    @FindBy(xpath = "//a[normalize-space()='List']")
    WebElement selectProductList;

    @FindBy(xpath = "//div[@class='picture']")
    WebElement selectProductFromDesktopPage;

    public void verifyDesktopText(String text){

        verifyThatTextIsDisplayed(desktopText, text);
        CustomListeners.test.log(Status.PASS, "Desktop text " + text);
    }
    public void sortByProduct(){

        clickOnElement(sortBy);
        CustomListeners.test.log(Status.PASS, "Sortby Product");
    }
    public void displayByProduct(){

        clickOnElement(displayBy);
        CustomListeners.test.log(Status.PASS, "Display by product ");
    }
    public void selectProductFromList(){

        clickOnElement(selectProductList);
        CustomListeners.test.log(Status.PASS, "Select product from List ");
    }
    public void productFromDesktopPage(String text){

        clickOnElement(selectProductFromDesktopPage, text);
        CustomListeners.test.log(Status.PASS, "Select product from Desktop  " + text);
    }




}
