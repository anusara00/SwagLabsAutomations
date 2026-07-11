package org.example.pages.tests;

import org.example.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void testEndToEndPurchase() {
        // 1. Log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(config.getProperty("validUsername"), config.getProperty("password"));

        // 2. Add two products
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        // 3. Confirm the cart badge count updates correctly (Task 3 Requirement)
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getCartBadgeCount(), "2", "Cart badge count is incorrect!");

        // 4. Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 5. Go through checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterDetails("John", "Doe", "12345");
        checkoutPage.clickContinue();

        // 6. Verify the order summary totals (Task 3 Requirement)
        // Re-using your excellent logic from your original assignment!
        String item1Price = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        String item2Price = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
        String itemTotalText = driver.findElement(By.className("summary_subtotal_label")).getText();

        double item1Double = Double.parseDouble(item1Price.replace("$", ""));
        double item2Double = Double.parseDouble(item2Price.replace("$", ""));
        double expectedItemTotal = Double.parseDouble(itemTotalText.replace("Item total: $", ""));

        Assert.assertEquals((item1Double + item2Double), expectedItemTotal, "Calculated item total does not match the displayed total!");

        // 7. Complete the order
        checkoutPage.clickFinish();

        // 8. Assert the confirmation message (Task 3 Requirement)
        String expectedConfirmation = "Thank you for your order!";
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), expectedConfirmation, "Order confirmation message did not match!");
    }
}