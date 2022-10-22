import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    By firstName = By.id("inputFirstName3");
    By lastName = By.id("inputLastName3");
    By email = By.id("inputEmail3");
    By gender = By.name("gridRadiosSex");
    By age = By.id("inputAge3");
    By experience = By.name("gridRadiosExperience");
    By profession = By.name("gridCheckboxProfession");
    By selectContinent = By.id("selectContinents");
    By selectCommandsBox = By.id("selectSeleniumCommands");
    By inputFile = By.id("chooseFile");
    By buttonClick=By.cssSelector("button[type='submit']");
    By validateForm=By.id("validator-message");


    @Test
    public void verifyFillFormWithSuccess() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/form.php");

        driver.findElement(firstName).sendKeys("Mirek");
        driver.findElement(lastName).sendKeys("Dyduch");
        driver.findElement(email).sendKeys("miros@wp.pl");
        //driver.findElement(sex).click();
        List<WebElement> genders = driver.findElements(gender);
        getRandomElement(genders).click();

        driver.findElement(age).sendKeys("41");

        List<WebElement> experiences = driver.findElements(experience);
        getRandomElement(experiences).click();

        List<WebElement> professions = driver.findElements(profession);
        getRandomElement(professions).click();
        //driver.findElement(experience).click();

        // typowy select
        Select continents = new Select(driver.findElement(selectContinent));
        //System.out.println(continents.getOptions().size());
        continents.selectByIndex(1);
        // --

        Select selectCommandsBoxes = new Select(driver.findElement(selectCommandsBox));
        selectCommandsBoxes.selectByValue("navigation-commands");

        //-- **********
        File inputFile1 = new File("notes.txt");
        WebElement element = driver.findElement(inputFile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(inputFile).sendKeys(inputFile1.getAbsolutePath());
        //-- **********
        driver.findElement(buttonClick).click();
        Assert.assertEquals(driver.findElement(validateForm).getText(),"Form send with success");

        Thread.sleep(2000);
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }
}
