package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    private void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        final Boolean loading = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
       if (loading) {
           System.out.println(driver.findElement(By.id("finish")).getText());
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.quit();
       }

    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

