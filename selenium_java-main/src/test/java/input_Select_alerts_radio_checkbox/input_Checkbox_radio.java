package input_Select_alerts_radio_checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class input_Checkbox_radio {

    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        driver.findElement(By.name("firstname")).sendKeys("vishajakhad");

        //Radiobox
        driver.findElement(By.id("sex-1")).click();

        //checkbox
        driver.findElement(By.id("tool-1")).click();


    }
}




// hi this is new change i want to commit as of now just to check the commit error need to delete this later.