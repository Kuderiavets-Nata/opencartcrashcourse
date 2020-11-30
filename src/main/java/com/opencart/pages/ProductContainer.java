package com.opencart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductContainer {
    private final WebElement element;

    public ProductContainer(WebElement element) {
        this.element = element;
    }

    public String getName() {
        return this.element.findElement(By.xpath(".//*[@class='caption']//h4")).getText();
    }

    public String getDescription() {
        return this.element.findElement(By.xpath(".//*[@class='caption']//p[1]")).getText();
    }

    public String getPrice() {
        return this.element.findElement(By.className("price")).getText();
    }

    public String getPriceTax() {
        return this.element.findElement(By.className("price-tax")).getText();
    }

    public WebElement getAddToCardButton() {
        return this.element.findElement(By.cssSelector("div.button-group i.fa fa-shopping-cart"));
    }

    public WebElement getAddToWishListButton() {
        return this.element.findElement(By.cssSelector("div.button-group i.fa fa-heart"));
    }

    public WebElement getCompareThisProduct() {
        return this.element.findElement(By.cssSelector("div.button-group i.fa fa-exchange"));
    }

}

