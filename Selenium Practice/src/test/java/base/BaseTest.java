package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        // TODO: 5/18/2021 : User Name
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // TODO: 5/18/2021 : Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // TODO: 5/18/2021 :  Submit submit
        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

