package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Utility {

    public DesktopsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;

    @FindBy(id = "products-orderby")
    WebElement sortby;

    @FindBy(id = "products-pagesize")
    WebElement display;

    @FindBy(xpath = "//a[normalize-space()='List']")
    WebElement selectProductList;

    @FindBy(xpath = "//div[@class='picture']")
    WebElement selectProductDesktpsPage;

    public void selectProductDesktpsPage(String product){
        clickOnElement(selectProductDesktpsPage,product);
        CustomListeners.test.log(Status.PASS, "Select Product: "+product);

    }

    public void verifyDesktopsText(String text) {
        verifyThatTextIsDisplayed(desktopsText, text);
        CustomListeners.test.log(Status.PASS, "Click on selectProductList");
    }

    public void selectSortBy(String sortBy) {
        selectByVisibleTextFromDropDown(sortby, sortBy);
        CustomListeners.test.log(Status.PASS, "Select SortBy: "+sortBy);
    }

    public void selectDisplay(String size) {
        selectByVisibleTextFromDropDown(display, size);
        CustomListeners.test.log(Status.PASS, "Select size: "+size);
    }

    public void clickOnList() {
        clickOnElement(selectProductList);
        CustomListeners.test.log(Status.PASS, "Click on selectProductList");

    }

}
