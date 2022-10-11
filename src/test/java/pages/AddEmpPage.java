package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(css = "div[class*='oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    public WebElement idInput;

    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;

    @FindBy(css = "//button[normalize-space()='Cancel']")
    public WebElement cancelButton;

    public void selectAddEmployee () {
        clickElement(addUserButton);
    }

    public void fillFirstName (String firstname) {
        clickElement(firstNameInput);
        firstNameInput.sendKeys(firstname);
    }

    public void fillMiddleName (String middleName) {
        clickElement(middleNameInput);
        middleNameInput.sendKeys(middleName);
    }

    public void fillLastName (String lastname) {
        clickElement(lastNameInput);
        lastNameInput.sendKeys(lastname);
    }

    public void saveNewEmployee () {
        clickElement(saveButton);
    }
}
