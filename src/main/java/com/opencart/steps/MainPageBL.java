package com.opencart.steps;

public class MainPageBL {

    public HeaderPageBL getHeaderPageBL() {
        return new HeaderPageBL();
    }

    public void verifyLogout() {
        getHeaderPageBL()
                .clickOnMyAccountButton()
                .checkLoginButton();
    }
}
