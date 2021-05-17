package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

class BaseTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        // TODO: 5/17/2021 : First name
        driver.findElement(By.id("firstName")).sendKeys("D");

        // TODO: 5/17/2021 : Lastname
        driver.findElement(By.id("lastName")).sendKeys("Kenneth");

        // TODO: 5/17/2021 : Email
        driver.findElement(By.id("userEmail")).sendKeys("phamtrungky@gmail.com");

        // TODO: 5/17/2021 : Gender
        //driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        if (!driver.findElement(By.id("genterWrapper")).isSelected()) {
            driver.findElement(By.id("genterWrapper")).click();
        }

        // TODO: 5/17/2021 : Phone number
        driver.findElement(By.id("userNumber")).sendKeys("0909099900");

        // TODO: 5/17/2021 : Date of birth
        driver.findElement(By.id("dateOfBirthInput")).findElement(By.xpath("//input[@id='dateOfBirthInput']"));

        // TODO: 5/17/2021 : Subject wrapper

        WebElement autoSubjects = driver.findElement(By.id("subjectsInput"));
        autoSubjects.sendKeys("en");
        autoSubjects.sendKeys(Keys.ENTER);

        /*List<WebElement> optionsToSelect = driver.findElements(By.xpath("//input[@id='subjectsInput']"));

        for(WebElement option : optionsToSelect){
            System.out.println(option);
            String textToSelect = "English";
            if(option.getText().equals(textToSelect)) {
                option.sendKeys(Keys.ENTER);
                break;
            }
        }*/

        // TODO: 5/17/2021 : Hobbies Checkbox
        if (!driver.findElement(By.id("hobbiesWrapper")).isSelected())
            driver.findElement(By.id("hobbiesWrapper")).click();

        // TODO: 5/17/2021 : Upload picture
        driver.findElement(By.id("uploadPicture")).sendKeys("E:\\DOCUMENTS\\N3 - DOCUMENTS\\SOFTWARE TESTING\\PROJECT TESTING\\Selenium Practice\\resources");

        // TODO: 5/17/2021 : Address
        driver.findElement(By.id("currentAddress")).sendKeys("Phu Yen");

        // TODO: 5/17/2021 : State and City
/*        Select selectMyElement = new Select(driver.findElement(By.tagName("div")));
        selectMyElement.selectByVisibleText("NCR");*/

        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();

        // TODO: 5/17/2021 : Dropdown : chưa làm được 
        driver.findElement(By.id("stateCity-wrapper")).findElement(By.id("state")).findElements(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[10]/div[2]/div[1]/div[1]/div[1]"));


        // TODO: 5/17/2021 :  Submit
        driver.findElement(By.id("submit")).click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();


    }

    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

