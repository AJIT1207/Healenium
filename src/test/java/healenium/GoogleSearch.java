package healenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class GoogleSearch {

    @Test
    public void search() {
        WebDriverManager.chromedriver().setup();
        //declare delegate
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("vmware");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']"));

        for (WebElement ele : list)
        {
           if(ele.getText().equalsIgnoreCase("vmware share price"))
           {
               ele.click();
               break;
           }
        }
    }
}