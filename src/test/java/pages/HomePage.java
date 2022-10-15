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

    public WebElement menuSelector(String option) {
        WebElement menuButton = driver.findElement(By.xpath("//span[text()='" + option + "']"));
        return menuButton;
    }

    public void checkHomePage() {
        WaitUntilElementVisible(menuSelector("Admin"));
        Assert.assertTrue(menuSelector("Admin").isDisplayed());
        WaitUntilElementVisible(menuSelector("PIM"));
        Assert.assertTrue(menuSelector("PIM").isDisplayed());
        WaitUntilElementVisible(menuSelector("Leave"));
        Assert.assertTrue(menuSelector("Leave").isDisplayed());
        WaitUntilElementVisible(menuSelector("Time"));
        Assert.assertTrue(menuSelector("Time").isDisplayed());
        WaitUntilElementVisible(menuSelector("Recruitment"));
        Assert.assertTrue(menuSelector("Recruitment").isDisplayed());
        WaitUntilElementVisible(menuSelector("My Info"));
        Assert.assertTrue(menuSelector("My Info").isDisplayed());
        WaitUntilElementVisible(menuSelector("Dashboard"));
        Assert.assertTrue(menuSelector("Dashboard").isDisplayed());
        WaitUntilElementVisible(menuSelector("Directory"));
        Assert.assertTrue(menuSelector("Directory").isDisplayed());
        WaitUntilElementVisible(menuSelector("Maintenance"));
        Assert.assertTrue(menuSelector("Maintenance").isDisplayed());
        WaitUntilElementVisible(menuSelector("Buzz"));
        Assert.assertTrue(menuSelector("Buzz").isDisplayed());
    }

    public void logOut() {
        clickElement(userDropDownButton);
        clickElement(logOutButton);
    }
}
