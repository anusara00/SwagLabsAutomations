package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By totalLabel = By.className("summary_total_label");
    private By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void clickContinue() { driver.findElement(continueBtn).click(); }
    public void clickFinish() { driver.findElement(finishBtn).click(); }
    public String getTotal() { return driver.findElement(totalLabel).getText(); }
    public String getConfirmationMessage() {
        return driver.findElement(completeHeader).getText();
    }
}