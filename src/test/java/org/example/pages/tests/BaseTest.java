package org.example.pages.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    // protected means these variables can be accessed by child test classes
    protected WebDriver driver;
    protected Properties config;

    @BeforeMethod
    public void setUp() {
        // 1. Load the properties file
        config = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            config.load(fis);
        } catch (IOException e) {
            System.out.println("Could not load config file: " + e.getMessage());
        }

        // 2. Initialize the WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 3. Set an implicit wait to replace Thread.sleep()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4. Navigate to the base URL from the config file
        driver.get(config.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        // TEMPORARY: Slow down the tear down so you can visually confirm the test
        try {
            Thread.sleep(2000); // Pauses for 2 seconds before closing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Quit the browser completely after each test completes
        if (driver != null) {
            driver.quit();
        }
    }
}