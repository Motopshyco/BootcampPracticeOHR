package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmployeeListPage extends BasePage {

    public EmployeeListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    public WebElement employeeListButton;

    @FindBy(css = "div[class*='oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    public WebElement idFilterInput;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;

    @FindBy(css = "div[class*='orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']")
    public WebElement searchTittle;

    @FindBy(css = ".oxd-icon.bi-trash")
    public WebElement deleteIcon;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    public WebElement acceptDelete;

    @FindBy(xpath = "//span[normalize-space()='No Records Found']")
    public WebElement emptyMessage;

    @FindBy(css = ".oxd-icon.bi-pencil-fill")
    public WebElement editEmployeeIcon;

    public WebElement nameSelector(String name) {
        WebElement nameString = driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]"));
        return nameString;
    }

    public void searchEmployee(String id) {
        clickElement(employeeListButton);
        WaitUntilElementVisible(idFilterInput);
        idFilterInput.sendKeys(id);
        clickElement(searchButton);
        WaitUntilElementVisible(searchTittle);
    }

    public void checkNewUser(String name) {
        WaitUntilElementVisible(nameSelector(name));
        String firstname = nameSelector(name).getText();
        Assert.assertEquals(name, firstname);
    }

    public void deleteEmployee() {
        clickElement(deleteIcon);
        clickElement(acceptDelete);
    }

    public void confirmDeleteEmployee() {
        WaitUntilElementVisible(emptyMessage);
        Assert.assertTrue(emptyMessage.isDisplayed());
    }

    public void editEmployee(String name) {
        WaitUntilElementVisible(nameSelector(name));
        clickElement(editEmployeeIcon);
    }
}
