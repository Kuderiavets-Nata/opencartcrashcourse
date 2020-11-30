package com.opencart.steps;

import com.opencart.pages.ProductContainer;
import com.opencart.pages.SearchResultPage;
import com.opencart.util.DriverUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPageBL {

    private final SearchResultPage searchResultPage;

    public SearchResultPageBL() {
        searchResultPage = new SearchResultPage();
    }

    public void clickOnSearchInDescriptionCheckbox() {
        new DriverUtils().clickOnElementJS(searchResultPage.getSearchInDescriptionCheckbox());
    }

    public void clickOnSearchInSubCategoryCheckbox() {
        new DriverUtils().clickOnElementJS(searchResultPage.getSearchInSubCategoryCheckbox());
    }

    public SearchResultPageBL clickOnSearchButtonInResultPage() {
        searchResultPage.getSearchButtonInResultPage().click();
        return this;
    }

    public SearchResultPageBL clickOnCategoryDropDown() {
        Select selectCategory = new Select(searchResultPage.CategoryDropDown());
        return this;
    }

    public void verifySearchResult(String parameter) {
        List<ProductContainer> productContainers = searchResultPage.getProductContainers();

        for (ProductContainer parameterContains : productContainers) {
            Assert.assertTrue(parameterContains.getName().toLowerCase().contains(parameter.toLowerCase()));
        }


    }


}

