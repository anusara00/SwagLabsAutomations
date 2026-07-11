# Swag Labs QA Automation Framework

## Project Overview
This repository contains a UI automation framework built for the [Sauce Demo (Swag Labs)](https://www.saucedemo.com/) website. It completes the automated testing requirements (Tasks 1-3) and manual testing requirements (Task 4) as outlined in the QA assignment.

## Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)

## Project Architecture
The framework is structured to separate test logic from page actions, ensuring the code is scalable and easy to maintain.
* `src/main/java/org/example/pages/` - Contains the Page Object classes (Locators and Actions).
* `src/test/java/org/example/tests/` - Contains the TestNG test scripts.
* `src/test/resources/config.properties` - Stores environment variables (URLs, credentials).

## How to Run the Tests
### Via IDE (IntelliJ)
1. Open the project in your IDE.
2. Ensure Maven dependencies are loaded.
3. Navigate to `src/test/java/org/example/tests/`.
4. Right-click on `LoginTest.java` or `PurchaseTest.java` and select **Run**.


## Manual QA Documentation (Task 4)
The manual exploratory testing requirement for the `problem_user` account has been completed.
Please refer to the `BUG_REPORT.md` file located in the root directory for the detailed bug write-ups, including Steps to Reproduce and Expected vs. Actual results.