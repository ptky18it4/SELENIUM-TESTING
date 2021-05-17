package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        // TODO: 5/18/2021 : First Name
        driver.findElement(By.id("first-name")).sendKeys("Alex");

        // TODO: 5/18/2021 : Last Name
        driver.findElement(By.id("last-name")).sendKeys("Kenneth");

        // TODO: 5/18/2021 : Job title
        driver.findElement(By.id("job-title")).sendKeys("Developer");

        // TODO: 5/18/2021 : Highest level of education
        if (!driver.findElement(By.xpath("//body/div[1]/form[1]/div[1]/div[4]")).isSelected()) {
            driver.findElement(By.id("radio-button-1")).click();
            Thread.sleep(2000);
        }

        // TODO: 5/18/2021 : Sex Check box
        if (!driver.findElement(By.xpath("//body/div[1]/form[1]/div[1]/div[5]")).isSelected())
            driver.findElement(By.id("checkbox-1")).click();
            System.out.println("Sex: " + driver.findElement(By.id("checkbox-1")).getText());
            Thread.sleep(2000);

        // TODO: 5/18/2021 : Years of experience:
        Select optionDropdown = new Select(driver.findElement(By.id("select-menu")));
        optionDropdown.getOptions().get(3).click();
        System.out.println("Years of experience:: " + optionDropdown.getOptions().get(3));
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Dropdown : " + optionDropdown.getOptions().get(3).getText());

        // TODO: 5/18/2021 : Date
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys(Keys.ARROW_LEFT);
        datePicker.sendKeys(Keys.ARROW_DOWN);
        datePicker.sendKeys(Keys.ENTER);
        datePicker.sendKeys(Keys.TAB);

        // TODO: 5/18/2021 :  Submit submit
        driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

