package scriptedTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webDrivers.strategies.WebDriverFactory;

public abstract class BaseTest {
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    protected WebDriver webDriver;
    String browser = "chrome";
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        webDriver = WebDriverFactory.getDriver(browser);
        webDriver.get(url);
        //webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }
}
