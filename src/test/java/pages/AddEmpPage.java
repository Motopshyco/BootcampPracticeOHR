package pages;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
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

    public void saveNewEmployee (String id) {
        clickElement(idInput);
        idInput.sendKeys(Keys.CONTROL + "a");
        idInput.sendKeys(Keys.DELETE);
        idInput.sendKeys(id);
        clickElement(saveButton);
    }
}
