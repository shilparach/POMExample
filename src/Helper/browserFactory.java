package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserFactory {

	public static WebDriver driver;
	String browser = null;
	String URL = null;
	
	public static WebDriver startBrowser(String Browser,String URL){
		if(Browser.equalsIgnoreCase("Firefox")){
		    driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ATNSW-Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\ATNSW-Admin\\Downloads\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}	
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		return driver;
		
	}
	
	
	
	
}
