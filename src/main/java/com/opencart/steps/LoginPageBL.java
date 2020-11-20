package com.opencart.steps;

import com.opencart.navigation.Navigation;
import com.opencart.pages.LoginPage;
import com.opencart.pages.SuccessLoginPage;
import com.opencart.util.RandomEmailUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageBL {

    private LoginPage loginPage;
    SuccessLoginPage successLoginPage;

    public LoginPageBL() {
        loginPage = new LoginPage();
    }


    public LoginPageBL loginUser(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickOnLoginButton();

        successLoginPage = new SuccessLoginPage();
        return this;
    }

    public LoginPageBL loginUserWithNewPassword() {
        loginUser(RandomEmailUtil.email, ForgottenPageBL.newPassword);
        return this;
    }

    public LoginPageBL verifyLoginWithNewPassword() {
        loginUserWithNewPassword()
                .verifyUserLogin();
        return new LoginPageBL();
    }

    public void verifyInvalidDataWarning() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(successLoginPage.getMyAccountTitle().getText(), expectedMessage, "Incorrect page title");
    }

    public LoginPageBL lockUser(String email) {
        do {
            loginUser(email, "wrong_password");
        } while (!lockMessage());
        return new LoginPageBL();
    }

    public ForgottenPageBL clickOnForgottenPassword() {
        loginPage.waitUntilFindElement(loginPage.getForgottenPasswordButton());
        loginPage.getForgottenPasswordButton().click();
        return new ForgottenPageBL();
    }

    private void inputEmail(String email) {
        loginPage.waitUntilFindElement(loginPage.getEmailInput());
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
    }

    private void inputPassword(String password) {
        loginPage.waitUntilFindElement(loginPage.getPasswordInput());
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
    }

    private void clickOnLoginButton() {
        loginPage.getLoginButton().click();
    }

    private boolean lockMessage() {
        loginPage.waitUntilFindElement(loginPage.getAlertMessage());
        String lockMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        return loginPage.getAlertMessage().getText().equals(lockMessage);
    }

    public void verifyUserLogin() {
        loginPage.waitUntilFindElement(successLoginPage.getMyAccountTitle());
        String expectedMessage = "My Account";
        Assert.assertEquals(successLoginPage.getMyAccountTitle().getText(), expectedMessage, "Incorrect page title");
    }
}
