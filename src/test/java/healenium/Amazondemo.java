package healenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Amazondemo {

    @Test
    public void hitthekeyword()
    {
        WebDriverManager.chromedriver().setup();
        //declare delegate
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("iphone");

        String text = "iphone charger";

        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'iphone')]"));  // //div[@class='autocomplete-results-container']/div/div[@class="s-suggestion-container"]

        for (WebElement ele : list)
        {
            if(ele.getText().equalsIgnoreCase(text))
            {
                ele.click();
                break;
            }
        }

      //  driver.quit();

    }
}
