package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        // TODO: 5/17/2021 : Username
        driver.findElement(By.name("username")).sendKeys("D");

        // TODO: 5/17/2021 : Password
        driver.findElement(By.name("password")).sendKeys("TuiLaPassword");

        // TODO: 5/17/2021 : TextArea Comment
        driver.findElement(By.name("comments")).sendKeys("Lorem ipsum....");

        // TODO: 5/17/2021 : Choose file
        driver.findElement(By.name("filename")).sendKeys("E:\\DOCUMENTS\\N3 - DOCUMENTS\\SOFTWARE TESTING\\PROJECT TESTING\\Selenium Practice\\resources\\vungro.jpg");
        //can use By cssSelector or name (path) as per convenience

        // TODO: 5/17/2021 : Check box Items
        if (!driver.findElement(By.name("checkboxes[]")).isSelected()) {
            driver.findElement(By.xpath("//tbody/tr[5]/td[1]/input[1]")).click();
            Thread.sleep(10000);
        }

        // TODO: 5/17/2021 : Radio Items
        if (!driver.findElement(By.name("radioval")).isSelected()) {
            driver.findElement(By.name("radioval")).click();
            Thread.sleep(10000);
        }

        // TODO: 5/17/2021 : Multi select value
        List<WebElement> optionSelected = Collections.singletonList(driver.findElement(By.name("multipleselect[]")));
        for (WebElement option : optionSelected) {
            System.out.println("Option: " +  option);
            option.click();
        }

        // TODO: 5/17/2021 : Dropdown
        List<WebElement> optionDropdown = Collections.singletonList(driver.findElement(By.name("dropdown")));
        for (WebElement option : optionDropdown) {
            System.out.println("Dropdown: " +  option);
            option.click();
        }

        // TODO: 5/17/2021 : Cancel button
//        driver.findElement(By.xpath("//tbody/tr[9]/td[1]/input[1]")).click();
        // TODO: 5/17/2021 :  Submit submit
        driver.findElement(By.xpath("//tbody/tr[9]/td[1]/input[2]")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

