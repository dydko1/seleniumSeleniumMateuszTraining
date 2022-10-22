import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBar1 extends TestBase {
    //By progressBar = By.className(".progress-label");
    By progressBar = By.xpath("//div[@class='progress-label'][contains(text(),'Complete!')]");

    @Test
    void waitForProgressBar1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://51.75.61.161:9102/progressbar.php");

        wait.until(ExpectedConditions.elementToBeClickable(progressBar));
        String text = driver.findElement(progressBar).getText();
        Assert.assertEquals(text, "Complete!");

//        driver.findElement(progressBar).getText();

        Thread.sleep(2500);
    }

    @Test
    void waitForProgressBar2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://51.75.61.161:9102/progressbar.php");

        wait.until(ExpectedConditions.elementToBeClickable(progressBar));
        driver.findElement(By.className("ui-progressbar-complete"));
        String text = driver.findElement(progressBar).getText();
        Assert.assertEquals(text, "Complete!");

//        driver.findElement(progressBar).getText();

        Thread.sleep(2500);
    }
}