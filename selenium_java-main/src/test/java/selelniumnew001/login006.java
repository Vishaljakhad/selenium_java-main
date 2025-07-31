package selelniumnew001;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class login006 {

    @Description("checking the login functionality with correct username and password and display the error if wrong password is given")
    @Test
    public void test_negative_koala_login() throws Exception {


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        //driver.get("https://koalaliving.com.au/customer");
        driver.get("https://koalaliving.com.au/login");
        //driver.manage().window().maximize();


//        <input name="email"
//         type="email"
//         class="TextFields_defaultTextBox__ZK4T_  form-control is-invalid"
//         value="">


        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("vishal@jabitsoft.com");
//
//        <input placeholder="Set password for (6-20 characters)"
//        name="password"
//        type="password"
//        class="TextFieldPassword_defaultTextBox__gbNYA  form-control is-invalid">


        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Vishal@123");



//        <button type="submit"
//        class=" Buttons_defaultBtnDark__O4ie4"> LOGIN
//        </button>

        WebElement LOGINbutton = driver.findElement(By.cssSelector(".Buttons_defaultBtnDark__O4ie4"));
        LOGINbutton.click();


        Thread.sleep(3000);
      //  driver.quit();

    }
    }


