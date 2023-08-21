import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumA1 {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        String expectedPageTitle = "OrangeHRM";
        String actualPageTitle= driver.getTitle();
        // if (actualPageTile.equals("OrangeHRM")) 0r

        if (expectedPageTitle.contains("OrangeHRM")){
            System.out.println("test case passed");
        }
        else
        {
            System.out.println("test case fail");

        }
        driver.quit();
    }
}
