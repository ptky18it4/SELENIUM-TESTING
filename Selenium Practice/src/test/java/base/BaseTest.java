package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        // TODO: 5/17/2021 : First Name
        driver.findElement(By.name("first_name")).sendKeys("Alex");

        // TODO: 5/17/2021 : Last Name
        driver.findElement(By.name("last_name")).sendKeys("TuiLaPassword");

        // TODO: 5/17/2021 : E-Mail
        driver.findElement(By.name("email")).sendKeys("phamtrungky@gmail.com");

        // TODO: 5/17/2021 : Phone #
        driver.findElement(By.name("phone")).sendKeys("8888888888");
        //can use By cssSelector or name (path) as per convenience

        // TODO: 5/17/2021 : Address
        driver.findElement(By.name("address")).sendKeys("Phu Yen - Viet Nam");

        // TODO: 5/17/2021 : City
        driver.findElement(By.name("city")).sendKeys("Tuy Hoa");

        // TODO: 5/17/2021 : State
        Select optionDropdown = new Select(driver.findElement(By.name("state")));
        optionDropdown.getOptions().get(3).click();
        System.out.println("Dropdown: " +  optionDropdown.getOptions().get(3));

        // TODO: 5/17/2021 : Zip Code
        driver.findElement(By.name("zip")).sendKeys("54645");


        // TODO: 5/17/2021 : Website or domain name
        driver.findElement(By.name("website")).sendKeys("www.google.com");

        // TODO: 5/17/2021 : Do you have hosting?;
        if (!driver.findElement(By.name("hosting")).isSelected()) {
            driver.findElement(By.name("hosting")).click();
            Thread.sleep(2000);
        }
        // TODO: 5/17/2021 : Project Description
        driver.findElement(By.name("comment")).sendKeys("Tui la comment ne");

        // TODO: 5/17/2021 :  Submit submit
        driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/section[1]/form[1]/fieldset[1]/div[13]/div[1]/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

