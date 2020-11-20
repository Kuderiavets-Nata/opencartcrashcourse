package com.opencart.pages;

import com.opencart.enums.AdminNavigationMenuButtons;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class AdminPage extends BasePage {

    @FindBy(id = "button-filter")
    public WebElement filterButton;

    @FindBy(id = "input-email")
    public WebElement customerEmailInput;

    @FindBy(id = "input-username")
    public WebElement adminNameInput;

    @FindBy(id = "input-password")
    public WebElement adminPasswordInput;

    @FindBy(xpath = ".//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = ".//div[@class = 'btn-group']/button")
    public WebElement actionDropdownButton;

    @FindBy(xpath = ".//*[@id='content']//div[contains(@class, 'alert-success')]")
    public WebElement successAlert;

    @FindBy(xpath = ".//i[@class = 'fa fa-unlock']")
    public WebElement unlockAccountButton;

    public WebElement clickOnMenuButton(AdminNavigationMenuButtons button) {
        return driver.findElement(By.xpath("//*[@id = '" + button.getId() + "']/a"));
    }

    public WebElement clickOnSubmenuButton(AdminNavigationMenuButtons button, String submenuName) {
        String s = "//*[@id = '" + button.getId() + "']//li/a[contains(text(), " + submenuName + ")]";
        System.out.println(s);
        return driver.findElement(By.xpath(s));
    }
}
