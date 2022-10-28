package stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import Manager.TestContext;
import Manager.PageObjectManager;
import pages.*;

public class KervDigitalSteps {
    
	TestContext testContext;
	KervdigitalHomePage kervDigitalHomePage;
	
//Constructor:
	public KervDigitalSteps(TestContext testContext)
	{
	   this.testContext = testContext;
	   
    }
	@Given("I navigate to Kerv Digital Website")
	public void i_navigate_to_kerv_digital_website() 
	{
		kervDigitalHomePage = testContext.getPageObjectManager().getKervdigitalHomePage();
	}

	@Given("I select to accept cookies")
	public void i_select_to_accept_cookies() 
	{
		kervDigitalHomePage.acceptCookies();
	}
	
	@When("I hoover on Careers")
	public void i_hoover_on_careers() 
	{
		kervDigitalHomePage.clickCareersLink();
	}
	
	@When("I select Job Opportunities")
	public void i_select_job_opportunities() 
	{
		kervDigitalHomePage.clickJobOpportunities();
	}
	
	@When("I Search Vacancies by Job Role")
	public void i_search_vacancies_by_job_role(DataTable jobRoles) 
	{
		kervDigitalHomePage.searchVacancies(jobRoles);
	}
	
	@When("I select the Job Role")
	public void i_select_the_job_role(DataTable jobRoleCountry) 
	{
		kervDigitalHomePage.selectJob(jobRoleCountry);
	}
	
	@When("I entered the required details to apply the job")
	public void i_entered_the_required_details_to_apply_the_job(DataTable candidateDetails)
	{
		kervDigitalHomePage.enterCandidatedetails(candidateDetails);
	}
	
	@When("select Privacy Policy")
	public void select_privacy_policy() 
	{
		kervDigitalHomePage.acceptPolicies();
	}
	
	@When("Submit the applictaion")
	public void submit_the_applictaion()
	{
		kervDigitalHomePage.submitApplication();
	}
	
	@Then("I see successful confirmation message")
	public void i_see_successful_confirmation_message() 
	{
		kervDigitalHomePage.confirmationMessage();
	}
}
