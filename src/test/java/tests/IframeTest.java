package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    //By iFrame1 = By.name("iframe1");

    @Test
    public void firstIFrame() throws InterruptedException {
        driver.get("http://automation-practice.emilos.pl/iframes.php");
        //driver.findElement(simpleAlert).click();
        driver.switchTo().frame("iframe1");
        Thread.sleep(100);

        //driver.findElement(By.className("dropdown")).getText();

        //driver.switchTo().frame("iframe1");

        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");

        driver.findElement(By.id("inputSurname3")).sendKeys("Dydko");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.className("dropdown")).getText();


        driver.switchTo().defaultContent();

        Thread.sleep(2000);
    }


    @Test
    public void secondIFrame() throws InterruptedException {
        driver.get("http://automation-practice.emilos.pl/iframes.php");
        //driver.findElement(simpleAlert).click();
        driver.switchTo().frame("iframe1");
        Thread.sleep(100);

        //driver.findElement(By.className("dropdown")).getText();

        //driver.switchTo().frame("iframe1");

        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");

        driver.findElement(By.id("inputSurname3")).sendKeys("Dydko");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.className("dropdown")).getText();


        driver.switchTo().defaultContent();

        Thread.sleep(2000);

    }
}
