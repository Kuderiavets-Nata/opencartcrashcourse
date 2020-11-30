package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {
    @FindBy(css = "div h2")
    private WebElement resultSearchTittle;

    @FindBy(css = "div.product-thumb")
    private List<WebElement> productContainers;

    @FindBy(name = "sub_category")
    private WebElement searchInSubCategoryCheckbox;

    @FindBy(id = "description")
    private WebElement searchInDescriptionCheckbox;

    public WebElement CategoryDropDown() {

        return driver.findElement(By.name("category_id"));
    }

    @FindBy(id = "button-search")
    private WebElement SearchButtonInResultPage;


    public WebElement getResultSearchTittle() {

        return resultSearchTittle;
    }

    public List<ProductContainer> getProductContainers() {

        return productContainers.stream()
                .map(ProductContainer::new)
                .collect(Collectors.toList());
    }

    public WebElement getSearchButtonInResultPage() {
        return SearchButtonInResultPage;
    }

    public WebElement getSearchInDescriptionCheckbox() {
        return searchInDescriptionCheckbox;
    }

    public WebElement getSearchInSubCategoryCheckbox() {
        return searchInSubCategoryCheckbox;
    }
}
