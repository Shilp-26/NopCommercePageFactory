package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

@Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterTxt("Register");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterBtn();
        registerPage.verifyFirstNameErrorMsg("First name is required.");
        registerPage.verifyLastNameErrorMsg("Last name is required.");
        registerPage.verifyEmailErrorMsg("Email is required.");
        registerPage.verifyPasswordErrorMsg("Password is required.");
        registerPage.verifyConfirmPasswordErrorMsg("Password is required.");
    }

    @Test(groups = {"sanity","regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Male");
        registerPage.enterFirstName("Harry");
        registerPage.enterLastName("Potter");
        registerPage.selectDateOfBirth("1","July","1999");
        registerPage.enterEmail(getRandomEmail());
        registerPage.enterPassword("Potter0934");
        registerPage.enterConfirmPassword("Potter0934");
        registerPage.clickOnRegisterBtn();
        registerPage.verifyRegistrationCompletedMsg("Your registration completed");
    }
}
