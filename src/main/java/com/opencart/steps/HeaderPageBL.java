package com.opencart.steps;

import com.opencart.pages.HeaderPage;


public class HeaderPageBL {

    private final HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.getMyAccountButton().click();
        return this;
    }

    public RegisterPageBL clickOnRegisterButton() {
        headerPage.getRegisterButton().click();
        return new RegisterPageBL();
    }

    private void clickOnSearchInput() {
        headerPage.getSearchInput().click();

    }

    private void inputSearchParameters(String parameters) {
        headerPage.getSearchInput().clear();
        headerPage.getSearchInput().sendKeys(parameters);
    }

    private void clickOnSearchButton() {
        headerPage.getSearchButton().click();

    }

    public SearchResultPageBL searchProduct(String parameters) {
        clickOnSearchInput();
        inputSearchParameters(parameters);
        clickOnSearchButton();
        return new SearchResultPageBL();
    }
}


