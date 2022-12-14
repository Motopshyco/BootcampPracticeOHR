package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditEmployeePage extends BasePage {
    public EditEmployeePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "div[class*='orangehrm-vertical-padding'] button[type='submit']")
    WebElement firstSaveButton;

    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    public WebElement personalDetailsTittle;

    public void savePersonalChanges() {
        WaitUntilElementVisible(firstSaveButton);
        firstSaveButton.click();
    }

    public void waitPersonalDetailsTittle() {
        WaitUntilElementVisible(personalDetailsTittle);
    }
}
