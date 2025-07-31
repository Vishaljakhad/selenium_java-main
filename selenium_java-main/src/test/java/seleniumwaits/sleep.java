package seleniumwaits;

import jdk.jfr.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class sleep {

    @Description("verify the koalaliving login")
    @Test

    public void test_verify_koalaliving() throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://koalaliving.com.au/");


        Thread.sleep(20000);  //jvm will be hault not webdriver


    }
}
