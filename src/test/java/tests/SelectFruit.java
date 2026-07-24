package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelectFruit {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // DİKKAT: Aşağıdaki adresi kendi bilgisayarınızdaki index1.html dosyasının yolu ile değiştirin.
        driver.get("file:///C:/Users/ozge.gungor/Desktop/html/index1.html");

        WebElement fruitDropDown = driver.findElement(By.id("fruits"));
        Select select = new Select(fruitDropDown);

        select.selectByVisibleText("Elma");
        Thread.sleep(2000);

        select.selectByIndex(1);
        Thread.sleep(2000);
        WebElement firstSelected = select.getFirstSelectedOption();
        System.out.println("İlk seçili meyve:" + firstSelected.getText());
        /*Html dosyasındaki kod multiple yani çoklu seçime izin veriyorsa elimizde birden fazla
        seçenek olbailir. Burada ilk olarak elmayı seçtik ve elimizde kaldı daha sonrasında ındex(1)
        yani muz seçtik ve yani elimizde hem elma hem muz var.Burada seçili olanların ilkini çağırmış
        olduk.
         */
        List<WebElement> fruits = select.getOptions();
        System.out.println("sırasıyla meyveler:");
        for (WebElement fruit : fruits) {
            System.out.println(fruit.getText());
        }
        select.deselectAll();
        select.selectByIndex(1);

        WebElement secim =select.getFirstSelectedOption();
        System.out.println("Son seçim şudur:"+ secim.getText());
        driver.quit();
    }
}
