package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsQuickStart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        /*Parantez içindeki # işareti css dilinde id anlamına gelir. Yani id = "products"
        olan elementi bulur ve menu adını verdiğimiz kutunun içine koyar.
         */
        WebElement menu = driver.findElement(By.cssSelector("#products"));
        Actions act = new Actions(driver); // act'e tarayıcının kontrolünü verdik.

        // Hover ve tıklama
        act.moveToElement(menu).click().perform();
        /*Fare imlecini menünün üzerine götür anlamına gelir.Örneğin alışveriş sitelerinde
        kategorilerin üzerine gelince menü aşağıya doğru açılır buna "hover" denir.

        click() sol tık yapar.

        perform() Zincir işlemlerde bunu en sona koymazsak o kod hiçbir şey yapmaz.
        Koda uygula komutunu verir.
         */

        driver.quit();
    }
}
