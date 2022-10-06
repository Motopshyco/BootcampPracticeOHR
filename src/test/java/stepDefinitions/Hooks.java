package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import webDrivers.strategies.WebDriverFactory;

public class Hooks {

    protected static WebDriver webDriver;

    @Before
    public void setup() throws Exception {
        String browser = System.getenv("browser");
        String url = System.getenv("url");
        webDriver = WebDriverFactory.getDriver(browser);
        webDriver.get(url);
    }

    @After
    public void tearDown() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }
}