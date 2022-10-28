package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/resources/Features",
		glue ="stepdefinition", monochrome = true,
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "html:target/cucumber-report"})

public class TestRunner extends AbstractTestNGCucumberTests{

}
