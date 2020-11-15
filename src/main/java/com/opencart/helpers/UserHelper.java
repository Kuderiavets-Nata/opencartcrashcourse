package com.opencart.helpers;

import com.opencart.steps.MainPageBL;

public class UserHelper {

    public static void lockUser(String email) {
        new MainPageBL().getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .lockUser(email);
    }

    public static void changePassword(String email){
        new MainPageBL().getHeaderPageBL()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .clickOnForgottenPassword()
                .changePasswordWithURL(email)
                .verifyChangePassword();
    }
}
