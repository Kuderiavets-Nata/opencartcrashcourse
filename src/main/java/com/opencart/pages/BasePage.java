package com.opencart.pages;

import com.opencart.driver.DriverRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverRepository.DRIVERS.get();
        wait = new WebDriverWait(driver, 300);
        PageFactory.initElements(driver, this);
    }

    public void waitUntilFindElement(WebElement element) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
