package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    public void fillLoginCredentials() {
        WaitUntilElementVisible(usernameInput);
        usernameInput.isDisplayed();
        usernameInput.sendKeys(System.getenv("user"));
        WaitUntilElementVisible(passwordInput);
        passwordInput.isDisplayed();
        passwordInput.sendKeys(System.getenv("password"));
    }
}
