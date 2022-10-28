package pages;

import Manager.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.datatable.DataTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.String;

import Manager.PageObjectManager;


public class KervdigitalHomePage extends WebDriverFacade 
{
	private static final Logger logger = LoggerFactory.getLogger("KervDigitalHomePage.class");
	WebDriver driver;
	
	
//Constructor:
	public KervdigitalHomePage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


//Cookies Element:
@FindBy(how =How.CSS, using = "p[class='_brlbs-refuse']")
private WebElement essentialCookies;

//Careers Link:
@FindBy(how=How.XPATH, using ="//header/div[2]/nav[1]/div[1]/div[6]")
private WebElement careersLink;

//JobOpportunities:
@FindBy(how=How.XPATH, using ="//header/div[2]/nav/div/div[6]/div[2]/div/div[2]/div[1]/a[2]")
private WebElement jobOpportunities;

//JobRole:
@FindBy(how=How.CSS, using= "input[class='search-field__input']")
private WebElement jobRole;

//Search JobRole:
@FindBy(how=How.CSS,using = "button[class='search-field__btn  fal fa-search']")
private WebElement searchClick;

//List of Jobs:
@FindBy(how=How.CSS,using = "div[class='search-results__list']")
private List<WebElement> jobList;

//First Name:
@FindBy(how=How.ID,using = "candidate_first_name")
private WebElement firstName;

//LastName:
@FindBy(how=How.ID,using = "candidate_last_name")
private WebElement lastName;

//Email:
@FindBy(how=How.ID, using ="candidate_email")
private WebElement email;

//Phone:
@FindBy(how=How.ID, using ="candidate_phone")
private WebElement phone;

//Resume:
@FindBy(how=How.ID, using ="resume")
private WebElement resume;

@FindBy(how=How.XPATH, using ="//*[@id=\"cta-form\"]/div/div/div/form/div[6]/div")
private List<WebElement> aPolicy;
//Policies:
/*@FindBy(how=How.ID,using ="by_submitting_your_application_you_are_agreeing_to_recruiterbox_processing_your_personal_data_in_acc-0")
private WebElement bPolicy;

@FindBy(how=How.ID,using ="recruiterbox_processes_your_data_in_the_usa_this_means_us_public_authorities_may_access_your_data_fo-0")
private WebElement aPolicy;*/

//Submit:
@FindBy(how=How.NAME,using ="_job_application_form")
private WebElement submit;

@FindBy(how=How.CSS, using ="p[class='form-feedback-message']")
private WebElement message;


//Method to accept cookies:
public void acceptCookies()
{
	logger.info("Accept only essential cookies");
	clickElement(essentialCookies);
}

//Method to click Careers Link:
public void clickCareersLink()
{
	logger.info("User Clicked On Careers Link");
	clickElement(careersLink);
}

//Method to Click JobOpportunities:
public void clickJobOpportunities()
{
	logger.info("User Clicked On Job Opportunities");
	clickElement(jobOpportunities);
}


//Method to Search Vacancies:
public void searchVacancies(DataTable jobRoles)
{
	logger.info("User Searches Vacanicies");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1500)");
	
	Map<String, String> jobRoleDetails = jobRoles.asMap(String.class,String.class);
	String jobRoleName = jobRoleDetails.get("JobRole");
	enterText(jobRole,jobRoleName);
	clickJs(searchClick);
}

//Method to Select the Job:
public void selectJob(DataTable jobRoleCountry)
{
	logger.info("User Select the Job");
	Map<String, String> jobRoleCountryDetails = jobRoleCountry.asMap(String.class,String.class);
	String jobCountry = jobRoleCountryDetails.get("Country");
	String jobRole    = jobRoleCountryDetails.get("JobRole");
	
	for (int i=0 ; i < jobList.size(); i++)
	{
		String role = jobList.get(i).getText();
	    if(jobList.get(i).getText().contains(jobRole))
	    { 
	    	WebElement jobTitle = jobList.get(i).findElement(By.xpath("//div[@class='search-results__item']/a"));
	    
	    	clickJs(jobTitle);
	    	
	    	Set<String> windows = driver.getWindowHandles();
	    	Iterator<String>it  = windows.iterator();
	    	String parentwindow = it.next();
	    	String childwindow  = it.next();
	    	driver.close();
	    	driver.switchTo().window(childwindow);
	    	break;
	    }
	}
}

//Method to Enter Candidate Details:
public void enterCandidatedetails(DataTable candidateDetails)
{
	logger.info("User Enter the Details");
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0,3000)");
	
	Map<String, String> cDetails = candidateDetails.asMap(String.class,String.class);
	
	String cFirstName = cDetails.get("FirstName");
	enterText(firstName,cFirstName);
	
	String cLastName = cDetails.get("LastName");
	enterText(lastName,cLastName);
	
	String cEmail    = cDetails.get("Email");
	enterText(email,cEmail);
	
	String cPhone    = cDetails.get("Phone");
	enterText(phone,cPhone);
	
	String cResume    = cDetails.get("Resume");
	enterText(resume,cResume);
	
}
//Method to Accept Privacy Policies:
public void acceptPolicies()
{
	logger.info("User Accept the Policies");
	for (int i=0 ; i < aPolicy.size(); i++)
	{
		WebElement policy = aPolicy.get(i).findElement(By.xpath("//div[@class='checkbox-container__item']/label"));
		clickJs(policy);
	}
	
	//clickJs(bPolicy);
}

//Method to Submit Application:
public void submitApplication()
{
	logger.info("User Submit the Application");
	clickJs(submit);
}

public void confirmationMessage()
{
  logger.info("Application submission is successful..");
  driver.quit();
}
}


