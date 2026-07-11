package org.example.pages.tests;

import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginWithEmptyFields() {
        // 1. Initialize the Page Object
        LoginPage loginPage = new LoginPage(driver);

        // 2. Perform the action
        loginPage.clickLogin();

        // 3. Assert the expected outcome
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message did not match for empty fields!");
    }

    @Test(priority = 2)
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        // Let's pass in a completely fake username to test bad credentials
        loginPage.loginAs("wrong_user_123", config.getProperty("password"));

        // Updated to match the actual system error for invalid credentials
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message did not match for invalid credentials!");
    }

    @Test(priority = 3)
    public void testLoginHappyPath() {
        LoginPage loginPage = new LoginPage(driver);

        // Using the valid standard_user from your config file
        loginPage.loginAs(config.getProperty("validUsername"), config.getProperty("password"));

        // Assert that the URL changed to the inventory (products) page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the products page after login!");
    }

    @Test(priority = 4)
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);

        // 1. Log in first to reach the Products page
        loginPage.loginAs(config.getProperty("validUsername"), config.getProperty("password"));

        // 2. Initialize the Products Page Object
        ProductsPage productsPage = new ProductsPage(driver);

        // 3. Perform the logout actions
        productsPage.clickMenu();
        productsPage.clickLogout();

        // 4. Assert that we are sent back to the login page
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the login page after logging out!");
    }
}
