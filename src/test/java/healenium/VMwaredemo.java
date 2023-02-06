package healenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VMwaredemo {

       @Test

       public void demo()
       {
           WebDriverManager.chromedriver().setup();

           WebDriver driver = new ChromeDriver();

           driver.get("https://www.google.com/");

           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

           driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("vmware");

             Actions act = new Actions(driver);

            act.sendKeys(Keys.ENTER);

            String expectedTest = "vmware";

           WebElement result =  driver.findElement(By.xpath("//input[@role='combobox']"));

           Assert.assertEquals(expectedTest, result);



       }
}
