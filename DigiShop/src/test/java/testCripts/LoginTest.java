package testCripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.ExcelUtility;
import genericLibrary.FileUtility;

public class LoginTest {

	@DataProvider(name = "login")
	public String[][] loginData() throws EncryptedDocumentException, IOException{
		return FileUtility.getExcelData("Login");
	}
	
	
	@Test(dataProvider = "login")
	public void login_001(String email, String password) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		
		driver.findElement(By.id("Password")).sendKeys(password);
		
		driver.findElement(By.cssSelector("[value='Log in']")).click();
	
		driver.quit();
	}
}
