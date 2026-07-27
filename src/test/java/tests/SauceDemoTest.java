package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SauceDemoTest {
    WebDriver driver;
    Actions act;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();

        java.util.Map<String, Object> prefs = new java.util.HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        // 2. Tarayıcı güvenlik ve pop-up baloncularını kaldıran argümanlar
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill-keyboard-accessory-view[4]");

        // Otomasyon ibaresini ve çakışmaları en aza indirgemek için
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        act = new Actions(driver);
    }

    @Test
    public void testSauceDemo() throws InterruptedException {

        WebElement input = driver.findElement(By.id("user-name"));
        act.click(input)
                .sendKeys("standard_user")
                .pause(Duration.ofMillis(400))
                .perform();

        WebElement sifre = driver.findElement(By.id("password"));
        act.click(sifre)
                .sendKeys("secret_sauce", Keys.ENTER)
                .pause(Duration.ofMillis(500))
                .perform();

        WebElement urun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        urun.click();
        Thread.sleep(400);

        WebElement sepeteEkle = driver.findElement(By.id("add-to-cart"));
        sepeteEkle.click();
        Thread.sleep(400);


        WebElement removebutonu = driver.findElement(By.id("remove"));

        Assertions.assertTrue(removebutonu.isDisplayed(), "ürün sepete eklenemedi!");

    }

    @AfterEach
    public void TearDown() throws InterruptedException {
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();
            System.out.println("Test done.");

        }
    }
}
