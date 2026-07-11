package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;

    // 1. Locators
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By titleText = By.className("title");
    private By cartBadge = By.className("shopping_cart_badge");

    // 2. Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogout() {
        // Create an explicit wait target of 5 seconds max
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the logout link is physically clickable before clicking it
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public String getPageTitle() {
        return driver.findElement(titleText).getText();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }
}