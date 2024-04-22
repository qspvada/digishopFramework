package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {
	
	@DataProvider(parallel = true, name = "data")
	public String[][] registerData() {
		String[][] data=new String[5][5];
		
		data[0][0]="nandan";
		data[0][1]="kumar";
		data[0][2]="nandanlashjkjhhjj@gmail.com";
		data[0][3]="nandanghj@143";
		data[0][4]="nandanghj@143";
		
		
		data[1][0]="Harsha";
		data[1][1]="Sir";
		data[1][2]="HarshaSir@gmail.com";
		data[1][3]="harshaShanti@143";
		data[1][4]="harshaShanti@143";
		
		data[2][0]="Tabrez";
		data[2][1]="Sir";
		data[2][2]="TabrezB@gmail.com";
		data[2][3]="Tabmaala@143";
		data[2][4]="Tabmaala@143";
		
		data[3][0]="Bharath";
		data[3][1]="Sir";
		data[3][2]="BarathSir@gmail.com";
		data[3][3]="BharathSomany@143";
		data[3][4]="BharathSomany@143";
		
		
		data[4][0]="Shambu";
		data[4][1]="Sir";
		data[4][2]="Shambusheela@gmail.com";
		data[4][3]="Shambusheela@143";
		data[4][4]="Shambusheela@143";
		
		return data;
	}
	

	@Test(dataProvider = "data")
	public void register_001(String firstName, String lastName, String email, String password, String confirmPassword) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on Register link
		driver.findElement(By.linkText("Register")).click();
		
		//Click on male radio button
		driver.findElement(By.id("gender-male")).click();
		
		//Enter first name
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		
		//Enter last name
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		//Enter email
		driver.findElement(By.id("Email")).sendKeys(email);
		
		//Enter password
		driver.findElement(By.id("Password")).sendKeys(password);
		
//		Enter confirm password
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
		
		//Click on Register button
		driver.findElement(By.id("register-button")).click();
		
		//Close the browser
		driver.quit();
		}
}
