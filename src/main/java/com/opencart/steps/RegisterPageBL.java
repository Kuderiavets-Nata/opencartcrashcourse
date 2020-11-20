package com.opencart.steps;

import com.opencart.datamodel.RegisterModel;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.SuccessRegisterPage;
import com.opencart.repository.RegisterModelRepository;
import com.opencart.util.DriverUtils;
import com.opencart.util.RandomEmailUtil;
import org.testng.Assert;

public class RegisterPageBL {

    private RegisterPage registerPage;
    private SuccessRegisterPage successRegisterPage;

    public RegisterPageBL() {
        registerPage = new RegisterPage();
    }

    public RegisterPageBL registerNewPerson() {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputEmail(RandomEmailUtil.getRandomEmail());
        inputTelephone(registerModel.getTelephone());
        inputPassword(registerModel.getPassword());
        chooseSubscribe(1);
        clickPolicyCheckbox();
        clickOnContinueButton();

        successRegisterPage = new SuccessRegisterPage();
        return this;
    }

    private void inputFirstName(String firstName) {
        registerPage.waitUntilFindElement(registerPage.getFirstNameInput());
        registerPage.getFirstNameInput().clear();
        registerPage.getFirstNameInput().sendKeys(firstName);
    }

    private void inputLastName(String lastName) {
        registerPage.waitUntilFindElement(registerPage.getLastNameInput());
        registerPage.getLastNameInput().clear();
        registerPage.getLastNameInput().sendKeys(lastName);
    }

    private void inputEmail(String email) {
        registerPage.waitUntilFindElement(registerPage.getEmailInput());
        registerPage.getEmailInput().clear();
        registerPage.getEmailInput().sendKeys(email);
    }

    private void inputTelephone(String telephone) {
        registerPage.waitUntilFindElement(registerPage.getTelephoneInput());
        registerPage.getTelephoneInput().clear();
        registerPage.getTelephoneInput().sendKeys(telephone);
    }

    private void inputPassword(String password) {
        registerPage.waitUntilFindElement(registerPage.getPasswordInput());
        registerPage.getPasswordInput().clear();
        registerPage.getPasswordInput().sendKeys(password);
        registerPage.getPasswordConfirmInput().clear();
        registerPage.getPasswordConfirmInput().sendKeys(password);
    }

    private void chooseSubscribe(int value) {
        new DriverUtils().clickOnElementJS(registerPage.getSubscribeRadioButton(value));
    }

    private void clickPolicyCheckbox() {
        new DriverUtils().clickOnElementJS(registerPage.getPolicy());
    }

    private void clickOnContinueButton() {
        registerPage.getContinueButton().click();
    }

    public void verifyUserRegistration() {
        registerPage.waitUntilFindElement(successRegisterPage.getSuccessTitle());
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(successRegisterPage.getSuccessTitle().getText(), expectedMessage, "Incorrect page title");
    }
}
