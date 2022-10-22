import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends TestBase {

    By simpleAlert = By.id("simple-alert");
    By prompt = By.id("prompt-alert");

    @Test
    public void firstAlert() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/alerts.php");
        //driver.findElement(simpleAlert).click();

        driver.findElement(prompt).click();
        //driver.switchTo().alert().accept();

        driver.switchTo().alert().sendKeys("Miro");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String alertMsg = driver.findElement(By.id("prompt-label")).getText();

        //System.out.println(alertMsg);
        //Assert.assertEquals(alertMsg, "OK button pressed");
        Assert.assertEquals(alertMsg, "Hello Miro! How are you today?");

        Thread.sleep(2000);

    }
}
