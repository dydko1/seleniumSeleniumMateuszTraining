package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    WebDriver driver;
    public FormPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName3")
    private WebElement inputLastName;

    @FindBy(id = "inputAge3")
    private WebElement inputAge;

    @FindBy(id = "inputEmail3")
    private WebElement inputEmail;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> selectGender;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> gridExperience;

    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> gridProfession;

    @FindBy(id = "selectContinents")
    private WebElement selectContinent;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement selectCommandsBox;

    @FindBy(id = "chooseFile")
    private WebElement inputFile;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonClick;

    @FindBy(id = "validator-message")
    private WebElement validateForm;

    //****************
    // pola i metody dla: lastName oraz email
    public void setFirstName(String name) {
        inputFirstName.sendKeys(name);
    }

    public void setLastName(String name) {
        inputLastName.sendKeys(name);
    }

    public void setInputEmail(String name) {
        inputEmail.sendKeys(name);
    }

    // String.valueOf(age) - zamienia 5 na "5"
    public void setAge(int age) {
        inputAge.sendKeys(String.valueOf(age));
    }

    public void selectRandomGender() {
        getRandomElement(selectGender);
    }

    public void selectExperience() {
        getRandomElement(gridExperience);
    }

    public void selectProfession() {
        getRandomElement(gridProfession);
    }

    public void selectContinent(int index) {
        new Select(selectContinent).selectByIndex(index);
    }

    public void selectCommands(int index) {
        new Select(selectCommandsBox).selectByIndex(index);
    }

    public void uploadFile(String file){
        File inputFile1 = new File(file);
        //WebElement element = driver.findElement(inputFile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", inputFile);
        inputFile.sendKeys(inputFile1.getAbsolutePath());
    }

    public void getRandomElement(List<WebElement> elements) {
        elements.get(new Random().nextInt(elements.size())).click();
    }

    public void clickSignIn(){
        buttonClick.click();
    }

    public String getConfirmationMessage() {
        return validateForm.getText();
    }
}