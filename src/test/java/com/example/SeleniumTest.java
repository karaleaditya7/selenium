package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void testGoogleSearch() throws MalformedURLException {
        // Set up ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        
        // Connect to Selenium Grid (use service name 'selenium-hub' instead of 'localhost')
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), chromeOptions);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Find the search box by name attribute
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            searchBox.submit();

            // Check the title contains "Selenium"
            assertTrue(driver.getTitle().contains("Selenium"));
        } finally {
            // Ensure the browser is closed
            driver.quit();
        }
    }
}
