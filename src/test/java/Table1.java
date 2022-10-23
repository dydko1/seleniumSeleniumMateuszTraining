import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Table1 extends TestBase {
    //By progressBar = By.className(".progress-label");
    By progressBar = By.xpath("//div[@class='progress-label'][contains(text(),'Complete!')]");

    @Test
    void waitForProgressBar1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://51.75.61.161:9102/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            int height = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());

            if (height > 4000) {
                System.out.println(row.findElements(By.cssSelector("td")).get(0).getText() + "\t" +
                        row.findElements(By.cssSelector("td")).get(1).getText() + "\t" + height);
            }
        }

        /*
        wait.until(ExpectedConditions.elementToBeClickable(progressBar));
        String text = driver.findElement(progressBar).getText();
        Assert.assertEquals(text, "Complete!");
*/
//        driver.findElement(progressBar).getText();

        Thread.sleep(2500);
    }

}