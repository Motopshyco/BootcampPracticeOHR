package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = ".oxd-userdropdown-tab")
    public WebElement userDropDownButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logOutButton;

    @FindBy(css = "img[alt='client brand banner']")
    public WebElement logoBanner;

    public WebElement menuSelector(String option) {
        WebElement menuButton = driver.findElement(By.xpath("//span[text()='" + option + "']"));
        return menuButton;
    }

    public void checkHomePage() {
        WaitUntilElementVisible(logoBanner);
        WaitUntilElementVisible(menuSelector("PIM"));
        Assert.assertTrue(menuSelector("PIM").isDisplayed());
        WaitUntilElementVisible(menuSelector("My Info"));
    }

    public void logOut() {
        WaitUntilElementVisible(logoBanner);
        clickElement(userDropDownButton);
        clickElement(logOutButton);
    }

    public void goToMyInfo() {
        clickElement(menuSelector("My Info"));
    }
}
