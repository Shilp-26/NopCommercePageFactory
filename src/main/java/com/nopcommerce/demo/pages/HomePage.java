package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutLink;


    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select Menu: "+menu);

    }

    public void verifyLogOutlink() {
        verifyThatElementIsDisplayed(logOutLink);
        CustomListeners.test.log(Status.PASS, "Verify Log out link is displayed");
    }

    public void clickOnLogOut() {
        clickOnElement(logOutLink);
        CustomListeners.test.log(Status.PASS, "Click on logOutLink");

    }

    public void verifyNopCommerceLogo() {
        verifyThatElementIsDisplayed(nopCommerceLogo);
        CustomListeners.test.log(Status.PASS, "Verify logo is displayed");

    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on myAccountLink");
    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Click on loginLink");

    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Click on registerLink");

    }

}
