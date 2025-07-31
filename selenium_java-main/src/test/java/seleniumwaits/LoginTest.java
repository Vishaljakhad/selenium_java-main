package seleniumnew001.seleniumwaits;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import seleniumnew001.pages.LoginPage;
import seleniumnew001.utils.TestUtil;

import java.lang.reflect.Method;

@Epic("Login Functionality")
@Feature("Invalid Login Attempts")
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.get("https://koalaliving.com.au/login");
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] credentials() {
        return new Object[][] {
                {"vishal@jabitsoft.com", "invalid123"},
                {"jabit@Jabitsoft.com", "info1234"}
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("User gets error for invalid credentials")
    @Description("Verify error message is shown for invalid login")
    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String email, String password, Method method) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "INVALID USERNAME OR PASSWORD", "Error message did not match");
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TestUtil.captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}