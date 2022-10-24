package tests;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTestPageFactory extends TestBase {

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
    By buttonClick = By.cssSelector("button[type='submit']");
    By validateForm = By.id("validator-message");


    @Test
    public void verifyFillFormWithSuccess() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/form.php");

        FormPage fillFormPage = new FormPage(driver);

        fillFormPage.setFirstName("Mirek");
        fillFormPage.setLastName("Dydko");
        fillFormPage.setInputEmail("Dydko@wp.pl");
        fillFormPage.setAge(30);
        fillFormPage.selectRandomGender();
        fillFormPage.selectExperience();
        fillFormPage.selectProfession();
        fillFormPage.selectContinent(1);
        fillFormPage.selectCommands(2);
        fillFormPage.uploadFile("notes.txt");
        fillFormPage.clickSignIn();
        String s = fillFormPage.getConfirmationMessage();

        Assert.assertEquals(s,"Form send with success");

        /*
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
*/
        Thread.sleep(2000);
    }


}
