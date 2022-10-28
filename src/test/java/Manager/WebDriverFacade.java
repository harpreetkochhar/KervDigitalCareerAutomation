package Manager;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class WebDriverFacade {
	private WebDriver driver;
	public String timestamp ="";
	//Senario senario;
	private static final Logger logger = LoggerFactory.getLogger("WebDriverFacade.class");
	
//Constructor:
	public WebDriverFacade(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
// Handle ClickElement:
	public void clickElement(WebElement element)
	{
		waitForElementToBeVisible(element); 
		waitForElementToBeClickable(element);
		element.click();
	}
	
//Javascript Click:
	public void clickJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);	
	}
	
//Explicit wait till Element is visible:
	public void waitForElementToBeVisible(WebElement element)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			System.out.println("Reason is: "+e.getCause());
		}
		
//
	}

//Explicit wait till Element is Clickable:
		public void waitForElementToBeClickable(WebElement element) //long timeInSeconds)
		{
			try
			{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			}catch(Exception e) {
				System.out.println("Reason is: "+e.getCause());
			}
		}
		
//To Enter Text:
		public void enterText(WebElement element, String textToEnter)
		{
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(textToEnter);
		}
	
}
