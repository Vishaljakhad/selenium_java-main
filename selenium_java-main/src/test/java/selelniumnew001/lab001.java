package selelniumnew001;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class lab001 {
    @Description("open the URL")
    @Test
    public static void main(String[] args) {

        // Optional: Set path to chromedriver if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://koalaliving.com.au/");



        // Get session ID (cast to RemoteWebDriver)
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();

        System.out.println("Session ID: " + sessionId);
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());




        // Close browser
        driver.quit();
    }
}
