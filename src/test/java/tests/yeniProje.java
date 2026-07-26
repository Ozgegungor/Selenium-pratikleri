package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class yeniProje {
    WebDriver driver;
    Actions act;

        @BeforeEach
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/droppable");
            act = new Actions(driver);
        }

        @Test
        public void dragAndDropTest() throws InterruptedException {

            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='70%'");
            Thread.sleep(1000);

            WebElement draggable = driver.findElement(By.id("draggable"));
            WebElement droppable = driver.findElement(By.id("droppable"));

            new Actions(driver)
                .clickAndHold(draggable)
                .moveByOffset(20, 0)
                .pause(Duration.ofMillis(500))
                .moveToElement(droppable)
                .pause(Duration.ofMillis(500))
                .release()
                .perform();

            Thread.sleep(2000);
            WebElement hedefKutusu = driver.findElement(By.id("droppable"));
            String kutuYazisi = hedefKutusu.getText();

            assertEquals("Dropped!",kutuYazisi);
        }
        @AfterEach
        public void tearDown() {
            if(driver != null) {
                driver.quit();
            }
        }
    }
