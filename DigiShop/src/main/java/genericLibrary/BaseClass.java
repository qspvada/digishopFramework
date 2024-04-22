package genericLibrary;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass  extends Utilitymethods{
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeSuite(alwaysRun = true)
	public void bs() {
		report=new ExtentReports(REPORT_PATH+getTime()+".html");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void as() {
		
		report.flush();
		Reporter.log("Close database connection",true);
	}
	
	@BeforeTest(alwaysRun = true)
	public void bt() {
		Reporter.log("Before test",true);
	}
	
	@AfterTest(alwaysRun = true)
	public void at() {
		Reporter.log("After test",true);
	}
	
	
//	@Parameters({"browser","url"})
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() {
		
		String browser=FileUtility.getProperty("browser");
		String url=FileUtility.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		initObjects(driver);
		Reporter.log("Browser launched",true);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Browser closed",true);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login(Method method) {
		
	    test=report.startTest(method.getName());
		
		
		String email=FileUtility.getProperty("email");
		String password=FileUtility.getProperty("password");
		//Click on Log in link
		driver.findElement(By.linkText("Log in")).click();
		
		//Enter the email
		driver.findElement(By.id("Email")).sendKeys(email);
		
		//Enter the password
		 driver.findElement(By.id("Password")).sendKeys(password);
		 
		 //Click on Login button
		 driver.findElement(By.className("login-button")).click();
		Reporter.log("Login",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("Log out",true);
		
		report.endTest(test);
	}
	
}
