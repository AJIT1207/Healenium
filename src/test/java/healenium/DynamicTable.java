package healenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicTable {

    @Test
    public void hitthekeyword() {
        WebDriverManager.chromedriver().setup();
        //declare delegate
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nseindia.com/market-data/top-gainers-loosers?cat=G");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        System.out.println(rows.size());

        for (WebElement row : rows)
        {
            List<WebElement> cols = driver.findElements(By.tagName("td"));

            System.out.println(cols.size());

            for (WebElement cell : cols)
            {
                System.out.println(cell.getText());
            }

        }




    }
}
