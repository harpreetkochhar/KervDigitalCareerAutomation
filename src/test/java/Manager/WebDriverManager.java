package Manager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;
import java.io.FileReader;
import java.util.*;
import java.lang.String;
import enums.DriverType;
import java.lang.Enum;

public class WebDriverManager {
	private WebDriver driver;
	private DriverType driverType;
	private final String Chrome_Driver_Property ="webdriver.chrome.driver";
	private static final Logger logger = LoggerFactory.getLogger("WebDriverManager.class");
	
//Constructor:
	
	public void WebDriverManger()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();		
	}
	
//Get driver:
	public WebDriver getDriver() throws Exception
	{
		if (driver == null) driver = createDriver();
		return driver;
	}
	
//Create driver:
	private WebDriver createDriver() //throws RuntimeException
	{
		//switch (driverType)
		//{
		//case CHROME:
			System.setProperty(Chrome_Driver_Property,FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
			driver = new ChromeDriver();
			//break;
		//case FIREFOX:
			//throw new RuntimeException("Firefox driver not implemente");		
		//}
        //driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().
				getImplicitlyWait(),TimeUnit.SECONDS);
		return driver;
	}
	
//Close browser:
	public void closebrowser()
	{
		driver.quit();	
	}
	
	
	
   

}
