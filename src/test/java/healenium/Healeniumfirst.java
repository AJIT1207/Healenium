package healenium;

import com.epam.healenium.annotation.DisableHealing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Healeniumfirst {

    WebDriver driver;
    //@DisableHealing
    @Test
    public void healniumtestgmail() throws InterruptedException {
      WebDriverManager.chromedriver().setup();

       // WebDriverManager.firefoxdriver().setup();
        //	WebDriver driver1 = new ChromeDriver();
        //declare delegate
        WebDriver delegate = new ChromeDriver();
        //create Self-healing driver
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(40000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
        driver.findElement(By.xpath("(//a[contains(text(),'Gmail')])[1]")).click();

      //  driver.findElement(withTagName("input").above(editbox).getText());

   //     driver.switchTo().newWindow(WindowType.TAB);

     //   driver.navigate().to("https://yahoo.com");

        driver.quit();
    }

}

