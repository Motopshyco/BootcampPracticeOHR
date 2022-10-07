package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement AdminButton;

    public void checkHomePage() {
        WaitUntilElementVisible(AdminButton);
        Assert.assertTrue(AdminButton.isDisplayed());
    }
}
