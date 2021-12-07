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
    WebElement registerTxt;

    @FindBy(id = "gender")
    WebElement gender;

    @FindBy(id = "FirstName")
    WebElement firstname;

    @FindBy(id = "LastName")
    WebElement lastname;

    @FindBy(name = "DateOfBirthDay")
    WebElement day;

    @FindBy(name = "DateOfBirthMonth")
    WebElement month;

    @FindBy(name = "DateOfBirthYear")
    WebElement year;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(id = "FirstName-error")
    WebElement firstNameRequiredTxt;

    @FindBy(id = "LastName-error")
    WebElement lastNameRequiredTxt;

    @FindBy(id = "Email-error")
    WebElement emailRequiredTxt;

    @FindBy(id = "Password-error")
    WebElement passwordRequiredTxt;

    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordRequiredTxt;

    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompletedMsg;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public void verifyRegistrationCompletedMsg(String msg) {
        verifyThatTextIsDisplayed(registrationCompletedMsg, msg);
    }

    public void clickOnContinueBtn() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on continueBtn");
    }

    public void verifyFirstNameErrorMsg(String msg) {
        verifyThatTextIsDisplayed(firstNameRequiredTxt, msg);
    }

    public void verifyLastNameErrorMsg(String msg) {
        verifyThatTextIsDisplayed(lastNameRequiredTxt, msg);
    }

    public void verifyEmailErrorMsg(String msg) {
        verifyThatTextIsDisplayed(emailRequiredTxt, msg);
    }

    public void verifyPasswordErrorMsg(String msg) {
        verifyThatTextIsDisplayed(passwordRequiredTxt, msg);
    }

    public void verifyConfirmPasswordErrorMsg(String msg) {
        verifyThatTextIsDisplayed(confirmPasswordRequiredTxt, msg);
    }

    public void enterEmail(String txt) {
        sendTextToElement(email, txt);
        CustomListeners.test.log(Status.PASS, "Enter email " + txt);

    }

    public void verifyRegisterTxt(String text) {
        verifyThatTextIsDisplayed(registerTxt, text);
    }

    public void selectGender(String genderCheckBox) {
        clickOnElement(gender, genderCheckBox);
    }

    public void enterFirstName(String first) {
        sendTextToElement(firstname, first);
        CustomListeners.test.log(Status.PASS, "Enter first name " + first);

    }

    public void enterLastName(String last) {
        sendTextToElement(lastname, last);
        CustomListeners.test.log(Status.PASS, "Enter last name " + last);

    }

    public void selectDateOfBirth(String dayDOB, String monthDOB, String yearDOB) throws InterruptedException {
        selectByVisibleTextFromDropDown(day, dayDOB);

        selectByVisibleTextFromDropDown(month, monthDOB);

        selectByVisibleTextFromDropDown(year, yearDOB);
        CustomListeners.test.log(Status.PASS, "Enter DOB " + dayDOB + monthDOB + yearDOB);

    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        CustomListeners.test.log(Status.PASS, "Enter password " + pass);

    }

    public void enterConfirmPassword(String confirmPass) {
        sendTextToElement(confirmPassword, confirmPass);
        CustomListeners.test.log(Status.PASS, "Enter confirm password " + confirmPass);

    }

    public void clickOnRegisterBtn() {
        clickOnElement(registerBtn);
        CustomListeners.test.log(Status.PASS, "Click on registerBtn");

    }
}
