package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void inIt() {

        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups ={"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText("Welcome, Please Sign In!");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

    @Test(groups ={"sanity","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {

            homePage.clickOnLoginLink();
            loginPage.enterEmailId("primetest123@gmail.com");
            loginPage.enterPassword("Test0987");
            loginPage.clickOnLoginButton();
            homePage.verifyLogOutlink();
        }

    @Test(groups ={"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("primetest123@gmail.com");
        loginPage.enterPassword("Test0987");
        loginPage.clickOnLoginButton();
        homePage.verifyLogOutlink();
        homePage.clickOnLogOut();
    }
    }

