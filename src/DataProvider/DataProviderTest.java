package DataProvider;

import org.testng.annotations.Test;

import Helper.browserFactory;
import pageFactory.gmailLoginPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	private static WebDriver driver;
	@DataProvider(name="Authentication")
	
	public static Object[][] credentials(){
		//The number of times data is repeated, the number of times the test will be executed.
		//Here, the test will be executed for two times
		return new Object[][]{{"shilpa.fico","shilparach"},{"tamushilpi","summer1984"}};
	}
	
	//Here we are calling the DataProvider object with its name
	
  @Test(dataProvider = "Authentication")
  public void checkGmailLogin(String sUsername,String sPassword) throws Exception {
	  
	  WebDriver driver = browserFactory.startBrowser("Firefox", "http://www.gmail.com");
	  
	  gmailLoginPageFactory gmailLogin = PageFactory.initElements(driver, gmailLoginPageFactory.class);
	  
	  gmailLogin.logintoGmailPF(sUsername, sPassword);
	  
	  driver.quit();
  }

  
}
