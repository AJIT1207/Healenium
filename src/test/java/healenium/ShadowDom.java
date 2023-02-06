package healenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDom {

    @Test
    public void search() {
        WebDriverManager.chromedriver().setup();
        //declare delegate
        WebDriver driver = new ChromeDriver();

        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";

        SearchContext shadow = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();

        shadow.findElement(By.cssSelector("#input")).sendKeys("Books");
    }
}
