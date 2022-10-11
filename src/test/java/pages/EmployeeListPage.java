package pages;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;

    public WebElement nameSelector(String name) {
        WebElement nameString = driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]"));
        return nameString;
    }

    public void checkNewUser(String id, String name) {
        clickElement(employeeListButton);
        WaitUntilElementVisible(idFilterInput);
        idFilterInput.sendKeys(id);
        clickElement(searchButton);
        WaitUntilElementVisible(nameSelector(name));
        String firstname = driver.findElement(By.xpath("//div[contains(text(),'"+ name + "')]")).getText();
        Assert.assertEquals(name, firstname);
    }
}
