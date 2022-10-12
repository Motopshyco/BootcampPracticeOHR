package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import webDrivers.strategies.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void setup() throws Exception {
        String browser = System.getenv("browser");
        webDriver = WebDriverFactory.getDriver(browser);
    }

    @After
    public void tearDown() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }
}
