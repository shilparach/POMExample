package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.gmailLoginpagePOM;

public class gmailLoginPOM {

	
	@Test
	public void verifyValidLogin(){
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		
		gmailLoginpagePOM login = new gmailLoginpagePOM(driver);
		/*
		login.typeUsername("shilpa.fico");
		login.typePassword("shilparach");
		login.clickonLoginButton();
		*/
		
		login.gmailLogin("shilpa.fico", "shilparach");
		driver.quit();
		
		
	}
}
