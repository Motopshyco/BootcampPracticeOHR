package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    public WebElement requiredMessage;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    public WebElement invalidCredentialsMessage;

    public void fillUserName(String userName) {
        WaitUntilElementVisible(usernameInput);
        usernameInput.sendKeys(userName);
    }

    public void fillPassword(String password) {
        WaitUntilElementVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void checkLoginPage() {
        WaitUntilElementVisible(usernameInput);
        WaitUntilElementVisible(passwordInput);
        WaitUntilElementVisible(loginButton);
        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void checkRequiredMessage() {
        WaitUntilElementVisible(requiredMessage);
        Assert.assertTrue(requiredMessage.isDisplayed());
    }

    public void checkInvalidCred() {
        WaitUntilElementVisible(invalidCredentialsMessage);
        Assert.assertTrue(invalidCredentialsMessage.isDisplayed());
    }
}
