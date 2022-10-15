package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ReportsPage;

import java.time.Duration;

public class ReportsSteps {
    private WebDriver driver = Hooks.webDriver;
    private WebDriverWait wait;
    private int timeout = Integer.parseInt(System.getenv("timeout"));
    public String name;

    public ReportsSteps() throws Exception {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Given("the user goes to the reports tab")
    public void the_user_goes_to_the_reports_tab() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.selectReportTab();
    }

    @When("the user creates a report with the name {string}")
    public void the_user_creates_a_report_with_the_name(String reportName) {
        ReportsPage reports = new ReportsPage(driver, wait);
        name = reportName;
        reports.setReportName(reportName);
        reports.selectReportOption();
        reports.saveReport();
    }

    @When("the new report should be show in the report list")
    public void the_new_report_should_be_show_in_the_report_list() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkCreatedReport();
    }

    @When("the user filters the reports using the name {string}")
    public void the_user_filters_the_reports_using_the_name(String reportName) {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.filterReport(reportName);
    }

    @Then("the report should appears in the list")
    public void the_report_should_appears_in_the_list() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkFiltered(name);
    }

    @When("the user deletes the created report")
    public void the_user_deletes_the_created_report() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.deleteReport();
    }

    @Then("the report should be deleted")
    public void the_report_should_be_deleted() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkMessage();
    }

    @When("the user tries to create another report with the same name")
    public void the_user_tries_to_create_another_report_with_the_same_name() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.setReportName(name);
    }

    @Then("the user should receive message the already exists")
    public void the_user_should_receive_message_the_already_exists() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkErrorNameMessage();
    }

    @When("the user tries to create a project without display field")
    public void the_user_tries_to_create_a_project_without_display_field() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.setReportName("test name");
        reports.saveReport();
    }

    @Then("the user should receive a warning message and continue in add report page")
    public void the_user_should_receive_a_warning_message_and_continue_in_add_report_page() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkMessage();
    }

    @When("the user tries to create a report without name")
    public void the_user_tries_to_create_a_report_without_name() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.setReportName("");
        reports.saveReport();
    }

    @Then("the user should receive required message")
    public void the_user_should_receive_required_message() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkErrorNameMessage();
    }
}
