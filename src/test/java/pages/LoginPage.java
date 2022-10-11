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

    @FindBy(css = "button[class*='orangehrm-login-button']")
    public WebElement loginButton;

    public void fillLoginCredentials() {
        WaitUntilElementVisible(usernameInput);
        usernameInput.sendKeys(System.getenv("user"));
        WaitUntilElementVisible(passwordInput);
        passwordInput.sendKeys(System.getenv("password"));
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
