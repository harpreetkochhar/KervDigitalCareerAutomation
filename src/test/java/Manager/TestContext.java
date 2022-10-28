


//This class has been set up for dependency injection to pass the pageobject manager from 
//one step to another
package Manager;

public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
//Constructor:
	public TestContext() throws Exception
	{
		webDriverManager  = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
  
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
	
	public WebDriverManager getWebDriverManager()
	{
		return webDriverManager;
	}
}
