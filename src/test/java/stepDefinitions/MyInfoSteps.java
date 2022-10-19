package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.MyInfoPage;

import java.time.Duration;

public class MyInfoSteps {

    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));
    public String userName;
    public String expectedName;

    public MyInfoSteps() throws Exception {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Given("the user goes to the My Info Tab")
    public void the_user_goes_to_the_my_info_tab() {
        HomePage home = new HomePage(driver, wait);
        home.goToMyInfo();
    }

    @When("the user reviews his name")
    public void the_user_reviews_his_name() {
        MyInfoPage myInfo = new MyInfoPage(driver, wait);
        myInfo.getUserName();
    }

    @Then("the name of the user should be in the tittle")
    public void the_name_of_the_user_should_be_in_the_tittle() {
        MyInfoPage myInfo = new MyInfoPage(driver, wait);
        myInfo.checkUserName();
    }

    @When("the user reviews his personal information")
    public void the_user_reviews_his_personal_information() {
        MyInfoPage myInfo = new MyInfoPage(driver, wait);
        myInfo.reviewInfo();
    }

    @Then("the personal information of  the user should appears in the tab")
    public void the_personal_information_of_the_user_should_appears_in_the_tab() {
        MyInfoPage myInfo = new MyInfoPage(driver, wait);
        myInfo.checkInfoPage();
    }
}
