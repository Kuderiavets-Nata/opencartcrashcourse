package com.opencart.navigation;

import com.opencart.driver.DriverRepository;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Navigation {

    private WebDriver driver;

    public Navigation() {
        driver = DriverRepository.DRIVERS.get();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void openNewTab(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public void closeCurrentTab() {
        driver.close();
    }
}
