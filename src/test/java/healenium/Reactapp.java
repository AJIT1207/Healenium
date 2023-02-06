package healenium;
import com.epam.healenium.annotation.DisableHealing;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Reactapp {

    WebDriver driver;
  // @DisableHealing
    @Test
    public void healniumtest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
      //  WebDriver driver = new ChromeDriver(options);

     //   WebDriverManager.chromedriver().setup();
        //	WebDriver driver1 = new ChromeDriver();
        //declare delegate
        WebDriver delegate = new ChromeDriver();
        //create Self-healing driver
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        driver.get("https://sha-test-app.herokuapp.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[contains(@class,'default-btn')]")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Thread.sleep(9000);
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
        driver.findElement(By.xpath("//span[contains(text(),'Generate New Markup')]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//button[contains(@class,'default-btn')]")).click();
        simpleAlert.accept();
        System.out.println("Script is passed");

    }
//    public byte[] screenshot() {
//        return ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BYTES);
//    }
}


