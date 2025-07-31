package seleniumwaits;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class fix_mini_project {

    @Test(description = "Verify that with invalid email/password, error message is shown")
    @Description("Checks login failure using incorrect credentials and validates error feedback.")
    public void testKoalaLivingLogin() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            driver.get("https://koalaliving.com.au/login");
            System.out.println("Page title: " + driver.getTitle());

            // Handle the popup alert (wait and close)
            try {
                WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement closeButton = popupWait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[aria-label='Close dialog']")));
                closeButton.click();
                System.out.println("Popup closed successfully.");
            } catch (TimeoutException e) {
                System.out.println("No popup appeared on page load.");
            }

            // Proceed with login
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailInput.sendKeys("vishal@jabitsoft.com");

            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("Vishal@123456");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='LOGIN']")));
            loginButton.click();

            // Wait and verify error message
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("span[style*='flex: 2 1 0%']")));

            wait.until(ExpectedConditions.textToBePresentInElement(errorMsg, "INVALID USERNAME OR PASSWORD"));

            System.out.println("Error Message: " + errorMsg.getText().trim());
            Assert.assertEquals(errorMsg.getText().trim(), "INVALID USERNAME OR PASSWORD");


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
