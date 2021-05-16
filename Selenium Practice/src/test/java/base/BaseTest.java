package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        driver.findElement(By.id("firstName")).sendKeys("D");
        driver.findElement(By.id("lastName")).sendKeys("Kenneth");
        driver.findElement(By.id("userEmail")).sendKeys("phamtrungky@gmail.com");
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0909099900");
        driver.findElement(By.id("dateOfBirthInput")).findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();

        //Selecting the first checkbox using XPath
        driver.findElement(By.xpath("//label[text()='Sports']")).click();

        //Selecting the second checkbox using Xpath
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[7]/div[2]/div[1]")).click();

        driver.findElement(By.id("uploadPicture")).sendKeys("E:\\DOCUMENTS\\N3 - DOCUMENTS\\SOFTWARE TESTING\\PROJECT TESTING\\Selenium Practice\\resources");
        Select state = new Select(driver.findElement(By.name("country")));
        state.selectByVisibleText("NRC");
        driver.findElement(By.id("submit")).click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();


    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

