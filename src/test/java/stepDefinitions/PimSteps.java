package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddEmpPage;
import pages.EmployeeListPage;
import java.time.Duration;

public class PimSteps {
    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));
    public String name;

    public PimSteps() throws Exception {
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
        name = name + " " + middleName;
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
        addEmp.saveNewEmployee();
    }
    @Then("the new employee should be show in the Employee List")
    public void the_new_employee_should_be_show_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee();
        employeeList.checkNewUser(name);
    }
    @When("the user delete the employee")
    public void the_user_delete_the_employee() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee();
        employeeList.deleteEmployee();
    }

    @Then("The employee should not appears in the Employee List")
    public void the_employee_should_not_appears_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee();
    }
}