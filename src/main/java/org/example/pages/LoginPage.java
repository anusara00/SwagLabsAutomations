package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // 1. Locators: We define exactly where the elements are on the page
    // Notice how we use cleaner By.id instead of long xpaths where possible
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // 2. Constructor: This forces the class to require a WebDriver to function
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions: These are the methods our tests will call
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // A helper method to do a full login in one line of code
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // We need this to verify errors for empty/invalid credentials
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}