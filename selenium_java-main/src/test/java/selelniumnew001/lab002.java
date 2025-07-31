package selelniumnew001;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class lab002 {

    public static void main(String[] args) {

        // Optional: Set path to chromedriver if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://koalaliving.com.au/");

        driver.manage().window().maximize();

        // Get session ID (cast to RemoteWebDriver)
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();

        System.out.println("Session ID: " + sessionId);
        System.out.println("Page Title: " + driver.getTitle());

        // Close browser
        driver.quit();
    }
}
