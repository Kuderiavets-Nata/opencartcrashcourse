package com.opencart.steps;

import com.opencart.navigation.Navigation;
import com.opencart.pages.HeaderPage;
import org.testng.Assert;

public class HeaderPageBL {

    private HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.waitUntilFindElement(headerPage.getMyAccountButton());
        headerPage.getMyAccountButton().click();
        return this;
    }

    public LoginPageBL clickOnLoginButton() {
        headerPage.waitUntilFindElement(headerPage.getLoginButton());
        headerPage.getLoginButton().click();
        return new LoginPageBL();
    }

    public LogoutPageBL clickOnLogoutButton() {
        headerPage.waitUntilFindElement(headerPage.getLogoutButton());
        headerPage.getLogoutButton().click();
        return new LogoutPageBL();
    }

    public RegisterPageBL clickOnRegisterButton() {
        headerPage.waitUntilFindElement(headerPage.getRegisterButton());
        headerPage.getRegisterButton().click();
        return new RegisterPageBL();
    }

    public void checkLoginButton() {
        Assert.assertTrue(headerPage.getLoginButton().isDisplayed(), "Account did not log out");
    }
}
