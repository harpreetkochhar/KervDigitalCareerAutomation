package Manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {
	private WebDriver driver;
	private KervdigitalHomePage kervDigitalHomePage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public KervdigitalHomePage getKervdigitalHomePage()
	{
		return (kervDigitalHomePage == null) ? kervDigitalHomePage = new KervdigitalHomePage(driver) : kervDigitalHomePage;
	}

}
