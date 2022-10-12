package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddEmpPage extends BasePage{

    public AddEmpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    public WebElement addUserButton;

    @FindBy(name = "firstName")
    public WebElement firstNameInput;

    @FindBy(name = "middleName")
    public WebElement middleNameInput;

    @FindBy(name = "lastName")
    public WebElement lastNameInput;

    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    public WebElement idInput;

    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;

    @FindBy(css = "//button[normalize-space()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    public WebElement personalDetailsTittle;

    @FindBy(xpath = "//label[normalize-space()='Employee Full Name']")
    public WebElement employeeFullNameTittle;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement duplicateIdMessage;

    @FindBy(css = "input[class=\"oxd-input oxd-input--active oxd-input--error\"]")
    public WebElement idInputError;

    public void selectAddEmployee () {
        clickElement(addUserButton);
    }

    public void fillFirstName (String firstName) {
        WaitUntilElementVisible(firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void fillMiddleName (String middleName) {
        WaitUntilElementVisible(middleNameInput);
        middleNameInput.sendKeys(middleName);
    }

    public void fillLastName (String lastname) {
        WaitUntilElementVisible(lastNameInput);
        lastNameInput.sendKeys(lastname);
    }

    public void saveNewEmployee () {
        clickElement(idInput);
        clickElement(saveButton);
        WaitUntilElementVisible(personalDetailsTittle);
    }

    public void editEmployeeName (String firstName, String middleName) {
        waitChargeTime();
        WaitUntilElementVisible(personalDetailsTittle);
        WaitUntilElementVisible(employeeFullNameTittle);
        firstNameInput.sendKeys(Keys.CONTROL + "a");
        firstNameInput.sendKeys(Keys.DELETE);
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(Keys.CONTROL + "a");
        middleNameInput.sendKeys(Keys.DELETE);
        middleNameInput.sendKeys(middleName);
    }

    public void changeEmployeeId (String id) {
        WaitUntilElementVisible(idInput);
        idInput.sendKeys(Keys.CONTROL + "a");
        idInput.sendKeys(Keys.DELETE);
        idInput.sendKeys(id);
    }

    public void checkErrorMessage () {
        WaitUntilElementVisible(duplicateIdMessage);
        Assert.assertTrue(duplicateIdMessage.isDisplayed());
    }
}
