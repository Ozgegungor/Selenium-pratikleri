package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelectExample {
     static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // pc de bir chrome tarayısı açar.
        driver.get("file:///C:/Users/ozge.gungor/Desktop/index.html");

        WebElement countryDropdown = driver.findElement(By.id("country"));
        /* sayfadaki HTML kodları içinde id değeri "country"
        olan elementi seçer muhtemelen <select> şeklinde.
         */

        // Select nesnesi oluşturulur
        Select select = new Select(countryDropdown);

        // 1️⃣ Görünen metne göre seçim
        select.selectByVisibleText("Türkiye");
        Thread.sleep(2000);
        // 2️⃣ Value attribute değerine göre seçim
        select.selectByValue("us");
        Thread.sleep(2000);

        // 3️⃣ Index değerine göre seçim (0'dan başlar)
        select.selectByIndex(2);
        Thread.sleep(2000);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Seçili ülke: " + selectedOption.getText());
        // En son seçtiğimiz ülkeyi döndürür yabi ındex 2 için

        driver.quit();
    }
