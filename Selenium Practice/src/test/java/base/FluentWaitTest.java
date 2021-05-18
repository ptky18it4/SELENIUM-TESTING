package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

class FluentWaitTest {
    private WebDriver driver;

    private void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        FluentWait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        System.out.println(driver.findElement(By.id("finish")).getText());
    }


    public static void main(String[] args) {
        FluentWaitTest fluentWait = new FluentWaitTest();
        fluentWait.setUp();
    }
}