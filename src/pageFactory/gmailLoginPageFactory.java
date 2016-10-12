package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class gmailLoginPageFactory {
	
	//locators through pagefactory
	public static WebDriver driver;
	
	@FindBy(how=How.ID,using="Email") 
	@CacheLookup
	WebElement username;
	@FindBy(how=How.ID,using="next")
	@CacheLookup
	WebElement next;
	@FindBy(how=How.ID,using="Passwd") 
	@CacheLookup
	WebElement password;
	@FindBy(how=How.ID,using="signIn") 
	@CacheLookup
	WebElement signIn;
	//@FindBy(xpath="//span[@class='gb_7a gbii']")
	//@FindBy(xpath="//a[(@class='gb_b gb_cb gb_R') and contains(@href,'SignOut')]")
	/*@FindBy(xpath="//*[contains(@href,'SignOut')]")
	WebElement signOutButton;
	//@FindBy(xpath="//a[(@id='gb_71') and contains(@href,'Logout')]")
	@FindBy(xpath="//*[contains(@href,'Logout')]")
	WebElement logOut;*/
	
	
	//Initialize the driver
	public gmailLoginPageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Login Method
	public void logintoGmailPF(String uid,String pass) throws Exception{
		username.sendKeys(uid);
		next.click();
		Thread.sleep(2000);
		password.sendKeys(pass);
		signIn.click();
		//signOutButton.click();
		//logOut.click();
		
	}
	


}
