package webDrivers.strategies;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome": {
                ChromeDriverCreator chrome = new ChromeDriverCreator();
                return chrome.createWebDriver();
            }

            case "firefox": {
                FirefoxDriverCreator firefox = new FirefoxDriverCreator();
                return firefox.createWebDriver();
            }

            default:
                throw new Exception("browser " + browser + " is not defined");
        }
    }
}
