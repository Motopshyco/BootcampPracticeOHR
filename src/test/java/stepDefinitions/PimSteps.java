package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddEmpPage;
import pages.EditEmployeePage;
import pages.EmployeeListPage;
import pages.ReportsPage;

import java.time.Duration;

public class PimSteps {
    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));
    public String name;
    public static String id;

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
        id = addEmp.idInput.getAttribute("value");
        addEmp.saveNewEmployee();
    }
    @Then("the new employee should be show in the Employee List")
    public void the_new_employee_should_be_show_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        EditEmployeePage editEmp = new EditEmployeePage(driver, wait);
        editEmp.waitPersonalDetailsTittle();
        employeeList.searchEmployee(id);
        employeeList.checkNewUser(name);
    }
    @When("the user delete the employee")
    public void the_user_delete_the_employee() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee(id);
        employeeList.deleteEmployee();
    }

    @Then("The employee should not appears in the Employee List")
    public void the_employee_should_not_appears_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee(id);
        employeeList.confirmDeleteEmployee();
    }

    @When("the user changes the name of the employee to {string} as first name and {string} as second name")
    public void the_user_changes_the_name_of_the_employee_to_as_first_name_and_as_second_name(String firstName, String secondName) {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        EditEmployeePage editEmp = new EditEmployeePage(driver, wait);
        employeeList.editEmployee(name);
        name = firstName + " " + secondName;
        editEmp.waitPersonalDetailsTittle();
        addEmp.editEmployeeName(firstName, secondName);
        editEmp.savePersonalChanges();
    }

    @Then("the name of the employee should change in the Employee List")
    public void the_name_of_the_employee_should_change_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        employeeList.searchEmployee(id);
        employeeList.checkNewUser(name);
    }

    @When("The user tries to create another employee with the same id")
    public void the_user_tries_to_create_another_employee_with_the_same_id() {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.changeEmployeeId(id);
    }
    @Then("the user should to receive an error message")
    public void the_user_should_to_receive_an_error_message() {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.checkErrorMessage();
    }

    @Then("the user get a required message")
    public void the_user_get_a_required_message() {
        AddEmpPage addEmp = new AddEmpPage(driver, wait);
        addEmp.checkNameRequired();
    }

    @Then("the new employee should be filter by name in the Employee List")
    public void the_new_employee_should_be_filter_by_name_in_the_employee_list() {
        EmployeeListPage employeeList = new EmployeeListPage(driver, wait);
        EditEmployeePage editEmp = new EditEmployeePage(driver, wait);
        editEmp.waitPersonalDetailsTittle();
        employeeList.searchEmployeeByName(name);
        employeeList.checkNewUser(name);
    }

    @Given("the user goes to the reports tab")
    public void the_user_goes_to_the_reports_tab() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.selectReportTab();
    }

    @When("the user creates a report with the name {string}")
    public void the_user_creates_a_report_with_the_name(String reportName) {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.setReportName(reportName);
        reports.selectReportOption();
        reports.saveReport();
    }

    @When("the new report should be show in the report list")
    public void the_new_report_should_be_show_in_the_report_list() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkCreatedReport();
    }
}
