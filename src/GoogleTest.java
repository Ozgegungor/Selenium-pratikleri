package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class GoogleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.tr/");

        WebElement input = driver.findElement(By.name("q"));

        new Actions(driver)
                .click(input)
                .sendKeys("test otomasyon", Keys.ENTER)
                .perform();

        Thread.sleep(15000);
        driver.quit();
    }
}
