package stepDefinitions;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class PreConditions {

    private WebDriver driver = Hooks.webDriver;
    @Given("the user goes to the page")
    public void the_user_goes_to_the_page(){
        String value = driver.getTitle();
        System.out.println(value);
    }
}
