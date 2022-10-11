package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddEmpPage;
import pages.EmployeeListPage;

import java.time.Duration;

public class AddNewEmployee {
    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));
    public String id;
    public String name;

    public AddNewEmployee() throws Exception {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Given("the user goes to the Add Employee tab")
    public void the_user_goes_to_the_add_employee_tab() {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.selectAddEmployee();
    }
    @When("the user sets {string} as a first name")
    public void the_user_sets_as_a_first_name(String firstName) {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        name = firstName;
        addEmp.fillFirstName(firstName);
    }
    @When("the user sets {string} as a middle name")
    public void the_user_sets_as_a_middle_name(String middleName) {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.fillMiddleName(middleName);
    }
    @When("the user sets {string} as a last name")
    public void the_user_sets_as_a_last_name(String lastName) {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.fillLastName(lastName);
    }
    @When("the user saves the new employee")
    public void the_user_saves_the_new_employee() {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        id = addEmp.idInput.getText();
        addEmp.saveNewEmployee();
    }
    @Then("the new employee should be show in the Employee List")
    public void the_new_employee_should_be_show_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.checkNewUser(id, name);
    }
}
