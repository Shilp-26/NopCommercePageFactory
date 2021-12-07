package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends Utility {

    public ComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computersText;

    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopLink;

    @FindBy(xpath = "//a[@title='Show products in category Notebooks'][normalize-space()='Notebooks']")
    WebElement notebooksLink;

    @FindBy(xpath = "//a[@title='Show products in category Software'][normalize-space()='Software']")
    WebElement softwareLink;

    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsMsg;

    public void verifyComputersText(String text){
        verifyThatTextIsDisplayed(computersText,text);
        CustomListeners.test.log(Status.PASS, "Verify Computers text"+text);

    }
    public void verifyDesktopsText(String text){
        verifyThatTextIsDisplayed(desktopsMsg,text);
        CustomListeners.test.log(Status.PASS, "Verify Desktops text"+text);

    }

    public void clickOnDesktopLink(){
        clickOnElement(desktopLink);
        CustomListeners.test.log(Status.PASS, "Click on desktopLink");

    }

    public void clickOnNotebooksLink(){
        clickOnElement(notebooksLink);
        CustomListeners.test.log(Status.PASS, "Click on notebooksLink");

    }

    public void clickOnSoftwareLink(){
        clickOnElement(softwareLink);
        CustomListeners.test.log(Status.PASS, "Click on softwareLink");

    }
}
