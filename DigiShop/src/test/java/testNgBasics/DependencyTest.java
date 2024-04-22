package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependencyTest {


	@Test(groups = {"smoke","FT"})
	public void register() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println("FT  smoke Register");
		//driver.get("fg");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "FT")//(dependsOnMethods = "register")
	public void login() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println("FT Login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "RT")//(dependsOnMethods = "login")
	public void addToCart() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println("RT Add to cart");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "RT")//(dependsOnMethods = "addToCart")
	public void payment() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		System.out.println("RT Payment");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	
}
