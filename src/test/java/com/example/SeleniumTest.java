package com.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set up ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        
        // Connect to Selenium Grid (use service name 'selenium-hub' instead of 'localhost')
        driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), chromeOptions);
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search box by name attribute
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Check the title contains "Selenium"
        assertTrue(driver.getTitle().contains("Selenium"));
    }

    @AfterClass
    public void tearDown() {
        // Ensure the browser is closed
        if (driver != null) {
            driver.quit();
        }
    }
}
