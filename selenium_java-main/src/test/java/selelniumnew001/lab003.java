package selelniumnew001;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class lab003 {

    @Description("open the Koala living and verify the title!")
    @Test
    public void lab003(){

        //open the url
        EdgeDriver driver = new EdgeDriver();  //Edgedriver is prebuild class
        //new Edgedriver(); --> POST request (local host: 56055), create new session endpoint

        // navigate to the get the url

        driver.get("https://koalaliving.com.au");

        //assert the url- validation
        Assert.assertEquals(driver.getCurrentUrl(),"https://koalaliving.com.au/");



        driver.quit();
    }

}
