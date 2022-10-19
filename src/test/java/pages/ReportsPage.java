package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ReportsPage extends BasePage{
    public ReportsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    public WebElement reportsButton;

    @FindBy(css = ".oxd-text.oxd-text--h5.oxd-table-filter-title")
    public WebElement reportsTittle;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addReportButton;

    @FindBy(css = ".oxd-text.oxd-text--h6.orangehrm-main-title")
    public WebElement addReportTittle;

    @FindBy(css = "input[placeholder='Type here ...']")
    public WebElement reportNameInput;

    @FindBy(css = "input[placeholder='Type for hints...']")
    public WebElement reportNameFilter;

    @FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
    public WebElement fieldGroupDropDown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div[2]/div[2]")
    public WebElement fieldGroupOption;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    public WebElement displayFieldDropDown;

    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    public WebElement displayFieldOption;

    @FindBy(xpath = "//div[@class='oxd-form-row']//div[2]//div[2]//div[2]//button[1]")
    public WebElement addFieldButton;

    @FindBy(css = ".oxd-text.oxd-text--p.orangehrm-report-field-name")
    public WebElement addedFieldText;

    @FindBy(css = "button[type='submit']")
    public WebElement mainButton;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    @FindBy(css = ".header-content")
    public WebElement headerTittle;

    @FindBy(css = ".oxd-text.oxd-text--h6.orangehrm-main-title")
    public WebElement createdTittle;

    @FindBy(css = "div[class='oxd-table-card'] div:nth-child(2) div:nth-child(1)")
    public WebElement filteredElement;

    @FindBy(css = "div[role='listbox']>div:nth-child(1)")
    public WebElement filterOption;

    @FindBy(css = ".oxd-icon.bi-trash")
    public WebElement deleteIcon;

    @FindBy(css = "button[class*='oxd-button--label-danger orangehrm-button-margin']")
    public WebElement acceptDelete;

    @FindBy(css = "div[id='oxd-toaster_1']")
    public WebElement alertMessage;

    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    public WebElement errorMessageInTheName;

    public WebElement filterSelector(String filteredName) {
        WebElement filteredElement = driver.findElement(By.xpath("//span[normalize-space()='" + filteredName + "']"));
        return filteredElement;
    }

    public void selectReportTab() {
        clickElement(reportsButton);
        WaitUntilElementVisible(reportsTittle);
    }

    public void setReportName(String reportName) {
        clickElement(addReportButton);
        WaitUntilElementVisible(addReportTittle);
        clickElement(reportNameInput);
        reportNameInput.sendKeys(reportName);
    }

    public void selectReportOption(){
        clickElement(fieldGroupDropDown);
        clickElement(fieldGroupOption);
        clickElement(displayFieldDropDown);
        clickElement(displayFieldOption);
        clickElement(addFieldButton);
        WaitUntilElementVisible(addedFieldText);
    }

    public void saveReport() {
        clickElement(mainButton);
    }

    public void checkCreatedReport() {
        WaitUntilElementVisible(headerTittle);
        Assert.assertTrue(createdTittle.isDisplayed());
    }

    public void filterReport(String name) {
        clickElement(reportNameFilter);
        reportNameFilter.sendKeys(name);
        WaitUntilElementVisible(filterOption);
        clickElement(filterOption);
        clickElement(searchButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void checkFiltered(String filteredName) {
        WaitUntilElementVisible(filteredElement);
        String name = filteredElement.getText();
        Assert.assertEquals(name, filteredName);
    }

    public void deleteReport() {
        WaitUntilElementVisible(filteredElement);
        clickElement(deleteIcon);
        clickElement(acceptDelete);
    }

    public void checkMessage() {
        WaitUntilElementVisible(alertMessage);
        Assert.assertTrue(alertMessage.isDisplayed());
    }

    public void checkErrorNameMessage() {
        WaitUntilElementVisible(errorMessageInTheName);
        Assert.assertTrue(errorMessageInTheName.isDisplayed());
    }

    public void checkAddReportPage() {
        WaitUntilElementVisible(addReportTittle);
        WaitUntilElementVisible(addFieldButton);
        WaitUntilElementVisible(fieldGroupDropDown);
        Assert.assertTrue(addReportTittle.isDisplayed());
        Assert.assertTrue(addFieldButton.isDisplayed());
        Assert.assertTrue(fieldGroupDropDown.isDisplayed());
    }
}
