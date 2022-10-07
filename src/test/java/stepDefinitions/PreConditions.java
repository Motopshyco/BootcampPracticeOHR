package stepDefinitions;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;

public class PreConditions {

    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));

    public PreConditions() throws Exception {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Given("the user goes to the page")
    public void the_user_goes_to_the_page(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.fillLoginCredentials();
    }
}
