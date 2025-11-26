package selenium_locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class locators {

    @Description("Verify VWO using Chrome browser")
    @Test
    public void test_login_vwo() {

        // Optional: if Selenium Manager fails to download correct driver, set the path manually:
        // System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // open Chrome maximized
        // chromeOptions.addArguments("--headless=new"); // uncomment for headless mode

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to VWO login page
        driver.get("https://app.vwo.com");

        // Wait until the link is clickable ( explicit wait )
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement freeTrialLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Start a free trial"))
        );

        // Click the link
        freeTrialLink.click();

        // Close the browse
        driver.quit();
    }
}
