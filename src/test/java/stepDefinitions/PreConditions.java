package stepDefinitions;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class PreConditions {

    @Given("the user goes to the page")
    public void the_user_goes_to_the_page(){
        LoginPage loginPage = new LoginPage(Hooks.webDriver);
        loginPage.usernameInput.sendKeys("Admin");
        System.out.println("si funcionó");
    }
}
