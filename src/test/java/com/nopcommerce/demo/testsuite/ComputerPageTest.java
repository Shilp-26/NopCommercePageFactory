package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYouOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends TestBase {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYouOwnComputerPage buildYouOwnComputerPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYouOwnComputerPage =new BuildYouOwnComputerPage();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.verifyComputersText("Computers");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.selectMenu("Computers");
        computerPage.clickOnDesktopLink();
        computerPage.verifyDesktopsText("Desktops");

    }

    @Test(dataProvider = "configuration",dataProviderClass = TestData.class,groups = {"sanity","regression"})
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
       verifyUserShouldNavigateToDesktopsPageSuccessfully();
        desktopsPage.selectProductDesktpsPage("Build your own computer");
        buildYouOwnComputerPage.buildConfigurationFromList(processor, ram, hdd, os, software);
        buildYouOwnComputerPage.clickOnAddToCart();
        buildYouOwnComputerPage.verifyProductHasBeenAddedMsg("shopping cart");

    }
}
