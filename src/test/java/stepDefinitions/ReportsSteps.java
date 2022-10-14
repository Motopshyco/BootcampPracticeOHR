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
        name = reportName;
        reports.filterReport(name);
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

    @Then("the report is deleted")
    public void the_report_is_deleted() {
        ReportsPage reports = new ReportsPage(driver, wait);
        reports.checkDeletedReport();
    }
}
