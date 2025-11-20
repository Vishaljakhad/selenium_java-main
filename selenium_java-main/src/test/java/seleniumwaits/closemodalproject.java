package seleniumwaits;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class closemodalproject {

    @Description("Verify makemytrip")
    @Test
    public void testclosemodal() {

        // Chrome Options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        // Start Chrome
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open URL
        driver.navigate().to("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        // Explicit wait for modal close button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='commonModal__close']"))
        );

        // Click close icon
        WebElement closeModal = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closeModal.click();

        // Pause to visually confirm result (not needed in real tests)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Quit driver
        driver.quit();
    }
}
