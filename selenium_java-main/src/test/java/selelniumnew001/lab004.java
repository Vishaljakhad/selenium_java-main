package selelniumnew001;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class lab004 {

    @Description("open the URL")
    @Test
    public void lab004() throws Exception {

        EdgeDriver driver = new EdgeDriver();  //Edgedriver is prebuild class

        driver.get("https://koalaliving.com.au");
        driver.manage().window().maximize();


        if(driver.getPageSource().contains("Best selling")){
            System.out.println("Best selling");

            Assert.assertTrue(true);
        }
        else {
            //Assert.assertTrue(false);
            throw new Exception("Best selling is not visible on the screen");

        }
        driver.quit();

    }
}