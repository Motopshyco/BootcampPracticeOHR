package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyInfoPage extends BasePage{
    public MyInfoPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = ".oxd-text.oxd-text--h6.--strong")
    public WebElement tittleName;

    @FindBy(css = "div[class='orangehrm-edit-employee-navigation'] div:nth-child(1) a:nth-child(1)")
    public WebElement personalDetailsButton;

    @FindBy(css = ".oxd-label.oxd-input-field-required")
    public WebElement employeeNameTittle;

    @FindBy(xpath = "//label[normalize-space()='Employee Id']")
    public WebElement employeeIdTittle;

    @FindBy(xpath = "//label[normalize-space()='Nationality']")
    public WebElement nationalityTittle;

    public void getUserName() {
        WaitUntilElementVisible(tittleName);
    }

    public void checkUserName() {
        Assert.assertTrue(tittleName.isDisplayed());
    }

    public void reviewInfo() {
        WaitUntilElementVisible(personalDetailsButton);
        WaitUntilElementVisible(employeeNameTittle);
        WaitUntilElementVisible(employeeIdTittle);
        WaitUntilElementVisible(nationalityTittle);
    }

    public void checkInfoPage() {
        Assert.assertTrue(personalDetailsButton.isDisplayed());
        Assert.assertTrue(employeeNameTittle.isDisplayed());
        Assert.assertTrue(employeeIdTittle.isDisplayed());
        Assert.assertTrue(nationalityTittle.isDisplayed());
    }
}
