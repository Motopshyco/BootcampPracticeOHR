package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class LoginSteps {

    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));

    public LoginSteps() throws Exception {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Given("the user navigates to the page")
    public void the_user_navigates_to_the_page() {
        String url = System.getenv("url");
        driver.get(url);
    }
    @When("the user submit the username and password")
    public void the_user_submit_the_username_and_password() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.fillLoginCredentials();
        loginPage.clickLoginButton();
    }
    @Then("the user should be logged into the page")
    public void the_user_should_be_logged_into_the_page() {
        HomePage home = new HomePage(driver, wait);
        home.checkHomePage();
    }

    @When("the user log out of the page")
    public void the_user_log_out_of_the_page() {
        HomePage home = new HomePage(driver, wait);
        home.logOut();
    }

    @Then("the user should be in the login page")
    public void the_user_should_be_in_the_log_in_page() {
        LoginPage login = new LoginPage(driver, wait);
        login.checkLoginPage();
    }
}
