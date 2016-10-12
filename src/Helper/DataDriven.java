package Helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven{
public WebDriver driver;
	
@Test(dataProvider="testData")
public void adminLogin(String Username,String Password){
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
WebDriver driver = new FirefoxDriver();
driver.get("http://www.gmail.com");
driver.findElement(By.name("Email")).sendKeys(Username);
driver.findElement(By.id("next")).click();
driver.findElement(By.name("Passwd")).sendKeys(Password);
driver.findElement(By.name("signIn")).click();
}
	
	
@DataProvider(name="testData")

public static Object[][] getLoginData() throws Exception, IOException {
	
	File f = new File("C:\\Users\\ATNSW-Admin\\Desktop\\SELENIUM\\TestData\\testData.xlsx");
	Workbook w = Workbook.getWorkbook(f);
	Sheet s  = w.getSheet("Sheet1");
	
	int rows = s.getRows();
	int columns = s.getColumns();
	
	//System.out.println(rows);
	//System.out.println(columns);
	
	
	String inputData[][] = new String [rows][columns];
	
	for(int i=1;i<rows;i++){
		for(int j=1;j<columns;j++){
			Cell c = s.getCell(j, i);
			inputData[i][j]=c.getContents();
			
		}
		
	}
		
	
	
	
	return null;
	
	
	
	
}

}