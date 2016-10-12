package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmailLoginpagePOM {
	
	WebDriver driver;
	
	By gmailUserName = By.name("Email");
	By gmailNext = By.id("next");
	By gmailPassword = By.name("Passwd");
	By gmailLoginButton = By.name("signIn");
	
	//create constructor
	
	public gmailLoginpagePOM(WebDriver driver){
		this.driver = driver;
	}
	
	/*public void typeUsername(String uid){
		
		driver.findElement(gmailUserName).sendKeys(uid);
		driver.findElement(gmailNext).click();		
	}
	

	public void typePassword(String pass){
		
		driver.findElement(gmailPassword).sendKeys(pass);
				
	}
	
	public void clickonLoginButton(){
		
		driver.findElement(gmailLoginButton).click();
				
	}*/
	
	public void loginInit(WebDriver driver,String URL)
	{
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.gmail.com");
		driver1.manage().window().maximize();
	}
	
	public void gmailLogin(String userid,String passwd)
	{
		driver.findElement(gmailUserName).sendKeys(userid);
		driver.findElement(gmailNext).click();
		driver.findElement(gmailPassword).sendKeys(passwd);
		driver.findElement(gmailLoginButton).click();
		
	}



	
	
}
