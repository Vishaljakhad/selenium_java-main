package selelniumnew001;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class lab19 {

    @Owner("Vishal")
    @Severity(SeverityLevel.BLOCKER)
    //@TmsLink("") // here we paste the Jira link. Like a testcase.
    @Description("Verify that the error message comes with invalid email")
    @Test
    public void vwo_free_trial_error_Verify() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // open Chrome maximized
        // chromeOptions.addArguments("--headless=new"); // uncomment for headless mode

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to VWO login page
        driver.get("https://app.vwo.com");

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("Start a free trial"));
        a_tag_partial_match.click();

        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial")); // verifying the current url after opening it (start a free trial)

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc");

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("invalid-reason"));

        // Check if the error message contains the expected text

        Assert.assertEquals(error_msg.getText(), "The email address you entered is incorrect.");

        driver.quit();
    }
}
