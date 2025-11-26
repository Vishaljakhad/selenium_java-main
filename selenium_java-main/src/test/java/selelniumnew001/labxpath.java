package selelniumnew001;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class labxpath {

    private static final Logger log = LoggerFactory.getLogger(labxpath.class);

    // /html/body/header/div/a
    @Owner("Vishal")
    @Severity(SeverityLevel.BLOCKER)
    //@TmsLink("") // here we paste the Jira link. Like a testcase.
    @Description("Verify that with valid email, pass, appointment page is loaded or not ")
    @Test

    public void test_katalon_login() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // open Chrome maximized
        // ChromeOptions.addArguments("--headless=new"); // uncomment for headless mode

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to katalon demo cura herokuapp .com
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_appointment_btn = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        make_appointment_btn.click();


        WebElement username_input_box = driver.findElement(By.xpath("//*[@id=\"txt-username\"]"));
        username_input_box.sendKeys("John Doe");

        //if id , classname anything is not present only place holder is present.
        //using place holder

//        List<WebElement> username_input_box_placeholder = driver.findElements(By.id("//input[@placeholder='username']"));
//        username_input_box_placeholder.get(1).sendKeys("Vishal jakhad");


        WebElement password_input_box = driver.findElement(By.xpath("//*[@id=\"txt-password\"]"));
       password_input_box.sendKeys("ThisIsNotAPassword");


        WebElement login_input_box = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
        login_input_box.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

       // driver.quit();


    }
}
