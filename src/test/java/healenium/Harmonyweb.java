package healenium;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Harmonyweb {

    WebDriver driver;
    // @DisableHealing
    @Test
    public void healniumHarmonyWebApp() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-notifications");
        WebDriverManager.chromedriver().setup();
        //declare delegate
        WebDriver delegate = new ChromeDriver();
        //create Self-healing driver and delegating the  WebDriver to SelfHealingDriver Interface
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //Opening the Harmony application
        driver.get("https://harmony.vmware.com/reports/global-dashboard");
        driver.findElement(By.xpath("//input[@id='discovery_username']")).sendKeys("jajit@vmware.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='next-btn']")).click();
        Thread.sleep(25000);
        //Clicking on "End to End Tests" in Harmony
        driver.findElement(By.xpath("//span[@class='nav-text'][normalize-space()='End to End Tests']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@class='activePage']")).click();
        Thread.sleep(40000);
        //Here We are changing the locator value in DOM during run with dev tools (F12)
        driver.findElement(By.xpath("//a[normalize-space()='Component Definitions']")).click();

        System.out.println("Script is passed");

    }

}


