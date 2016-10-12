package tests;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.browserFactory;
import jxl.Sheet;
import jxl.Workbook;
import pageFactory.gmailLoginPageFactory;

public class gmailLoginPF {

	
	@Test
	public void checkGmailLogin() throws Exception
	
	{
		//Launch the browser and URL
		WebDriver driver = browserFactory.startBrowser("firefox", "http://www.gmail.com");
		
		gmailLoginPageFactory gmailLogin = PageFactory.initElements(driver, gmailLoginPageFactory.class);
		
		gmailLogin.logintoGmailPF("shilpa.fico", "shilparach");
		
	}
	
			
}
