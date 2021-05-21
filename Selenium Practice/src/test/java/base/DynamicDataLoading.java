package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDataLoading {
    private WebDriver driver;

    /*    private void setUp() {
            driver = new ChromeDriver();
            driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[@id='save']")).click();
            FluentWait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS)
                    .pollingEvery(2, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading")));

            *//*Get the text after ajax call*//*
    }*/
    private void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        driver.manage().window().maximize();

        driver.findElement(By.id("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading")));
        // Test
        waitForAjax();
        geNodeText(driver.findElement(By.id("loading")));
        // End test
//        driver.quit();

    }

    public static String geNodeText(WebElement element) {
        String text = element.getText();
        for (WebElement child : element.findElements(By.xpath("./*"))) {
            text = text.replaceFirst(child.getText(), "");
        }
        System.out.println("Data: " + text);
        return text;
    }

    public void waitForAjax() throws InterruptedException {
        while (true) {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete) {
                System.out.println("Ajax Call completed. ");
                break;
            }
            Thread.sleep(150);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DynamicDataLoading dynamicDataLoading = new DynamicDataLoading();
        dynamicDataLoading.setUp();
    }
}
