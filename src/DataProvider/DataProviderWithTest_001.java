package DataProvider;

import org.testng.annotations.Test;

import Helper.browserFactory;
import Utility.ExcelUtils;
import pageFactory.gmailLoginPageFactory;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderWithTest_001 {
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() throws Exception{
		  WebDriver driver = browserFactory.startBrowser("Firefox", "https://www.mail.google.com");
		 /*driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");*/
	  }
	 
  @Test(dataProvider = "Authentication")
  public void gmailLogin(String UserName, String Password) throws Exception{
	  
	    driver.findElement(By.name("Email")).sendKeys(UserName);
		driver.findElement(By.name("signIn")).submit();
		driver.findElement(By.name("Passwd")).sendKeys(Password);
		//driver.findElement(By.name("PersistentCookie")).click();
		driver.findElement(By.name("signIn")).submit();
  }
  
  @DataProvider(name="Authentication")
  public Object[][] Authentication() throws Exception {
	  Object [][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\ATNSW-Admin\\Desktop\\SELENIUM\\TestData\\testData.xlsx", "Data1");
	  return (testObjArray);
    }

  @AfterMethod
  public void afterMethod() throws Exception{
	  driver.close();
  }


  
}
