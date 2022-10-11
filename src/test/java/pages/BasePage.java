package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
        PageFactory.initElements(driver, this);
    }

    protected void WaitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
    }

    protected void clickElement (WebElement element) {
        WaitUntilElementVisible(element);
        element.click();
    }

}
