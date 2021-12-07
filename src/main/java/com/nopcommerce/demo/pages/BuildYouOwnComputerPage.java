package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildYouOwnComputerPage extends Utility {

    public BuildYouOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputerPageTxt;

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropDown;

    @FindBy(id = "product_attribute_input_3")
    WebElement hddRadio;

    @FindBy(id = "product_attribute_input_4")
    WebElement osRadio;

    @FindBy(id = "product_attribute_input_5")
    WebElement softwareCheckBoxes;

    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement productHasBeenAddedMsg;

    public void buildConfigurationFromList(String processor, String ram, String hdd, String os, String software){
        selectByVisibleTextFromDropDown(processorDropDown, processor);
        selectByVisibleTextFromDropDown(ramDropDown, ram);
        clickOnElement(hddRadio, hdd);
        clickOnElement(osRadio,os);
        clickOnElement(softwareCheckBoxes, software);
    }

    public void verifyBuildYourOwnComputerPageTxt() {
        verifyThatTextIsDisplayed(buildYourOwnComputerPageTxt, "Build your own computer");
    }

    public void selectProcessor(String processor) {
        selectByVisibleTextFromDropDown(processorDropDown, processor);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Click on addToCartBtn");
    }

    public void verifyProductHasBeenAddedMsg(String text) {
        verifyThatTextIsDisplayed(productHasBeenAddedMsg, text);
    }

    public void selectRAM(String ram) {
        selectByVisibleTextFromDropDown(ramDropDown, ram);
    }

    public void selectHDDRadio(String hdd) {
        clickOnElement(hddRadio, hdd);
    }

    public void selectOSRadio(String os) {
        clickOnElement(osRadio, os);
    }


}
