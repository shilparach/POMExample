package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.browserFactory;
//import Utility.ExcelUtils;
import Utility.ExcelUtils_TestCaseName;
import pageFactory.gmailLoginPageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

public class DataProviderWithTest_002 {
	WebDriver driver;
	browserFactory objLogin;
	gmailLoginPageFactory gmailLogin;
	
	public String Browser;
	public String URL;
	public String uid;
	public String pass;
	
	 
	@Parameters({"Browser","URL"})
	@BeforeMethod

	public void beforeMethod(String Browser,String URL){
	
	//@Test(dataProvider = "Authentication")
	//public void gmailLogin(String uid,String pass)throws Exception{
		
	//driver= browserFactory.startBrowser("Firefox", "http://www.gmail.com");
	driver= browserFactory.startBrowser(Browser, URL);	
		
	}

   @Test(dataProvider = "Authentication")
  public void gmailLogin(String uid,String pass)throws Exception{
	   
	   	gmailLogin= new gmailLoginPageFactory(driver);
	   
	  
	    //gmailLoginPageFactory gmailLogin = PageFactory.initElements(driver, gmailLoginPageFactory.class);
		
		  //try {
	    gmailLogin.logintoGmailPF(uid, pass);
	    
			/*} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
				}*/
		
	 }
	  
	@DataProvider(name="Authentication")
	  public Object[][] Authentication() throws Exception {
		  //Object [][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\ATNSW-Admin\\Desktop\\SELENIUM\\TestData\\testData.xlsx", "Data1");
		  //return (testObjArray);
		  
		  ExcelUtils_TestCaseName.setExcelFile("C:\\Users\\ATNSW-Admin\\Desktop\\SELENIUM\\TestData\\testData.xlsx", "Data1");
		  String sTestCaseName = this.toString();
		  
		// From above method we get long test case name including package and class name etc.
		  
		 // The below method will refine your test case name, exactly the name use have used
		  
		  sTestCaseName = ExcelUtils_TestCaseName.getTestCaseName(this.toString());
		  
		// Fetching the Test Case row number from the Test Data Sheet
		  
		 // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
		  
		  int iTestCaseRow = ExcelUtils_TestCaseName.getRowContains(sTestCaseName, 0);
		  
		  Object[][] testObjArray = ExcelUtils_TestCaseName.getTableArray("C:\\Users\\ATNSW-Admin\\Desktop\\SELENIUM\\TestData\\testData.xlsx", "Data1", iTestCaseRow);
		  
		  return (testObjArray);
	   
		  
	    }
	 
  
  @AfterMethod
  public void aftermethod() {
	  driver.close();
	  driver.quit();
  }


  
}
