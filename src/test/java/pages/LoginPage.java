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

    @FindBy(css = "img[alt='client brand banner']")
    public WebElement logoBanner;

    public void fillLoginCredentials() {
        WaitUntilElementVisible(usernameInput);
        usernameInput.sendKeys(System.getenv("user"));
        WaitUntilElementVisible(passwordInput);
        passwordInput.sendKeys(System.getenv("password"));
    }

    public void clickLoginButton() {
        clickElement(loginButton);
        WaitUntilElementVisible(logoBanner);
    }

    public void checkLoginPage() {
        WaitUntilElementVisible(usernameInput);
        WaitUntilElementVisible(passwordInput);
        WaitUntilElementVisible(loginButton);
        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
