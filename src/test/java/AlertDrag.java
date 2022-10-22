
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class AlertDrag extends TestBase {
    By dragSquare = By.id("draggable");
    By dropDest = By.id("droppable");

    By buttonDelayedAlert = By.id("delayed-alert");


    @Test
    public void dragElement() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement from = driver.findElement(dragSquare);

        Actions act = new Actions(driver);

        Thread.sleep(500);
        //Dragged and dropped.
        act.dragAndDropBy(from, 200, 200).perform();

        Thread.sleep(2500);
    }

    @Test
    public void dropElement() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/droppable.php");

        Thread.sleep(500);
        WebElement from = driver.findElement(dragSquare);
        WebElement dest1 = driver.findElement(dropDest);

        Actions act = new Actions(driver);
        Thread.sleep(500);
        act.dragAndDrop(from, dest1).build().perform();
        //act.dragAndDropBy(from, 150,20).build().perform();

        System.out.println(dest1.findElement(By.cssSelector("p")).getText());
        Thread.sleep(2500);

    }

    @Test
    public void clickDelayAlert() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://51.75.61.161:9102/alerts.php");
        driver.findElement(buttonDelayedAlert).click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }
}