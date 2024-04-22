package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority = -1,groups = "RT")
	public void register() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("RT Register", true);
		//driver.get("fg");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority = 0, groups = "smoke")
	public void login() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log(" smoke Login",true);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority = 3, groups = {"smoke","RT"})
	public void addToCart() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log(" Smoke RT Add to cart",true);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = {"RT"})//(priority = 4)
	public void payment() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log(" RT Payment");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
}
