package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisableScripts {

	@Test(groups = "IT" )//(invocationCount = 1,threadPoolSize = 100)
	public void test1() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("IT Test cae 1");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
	

	@Test(groups = "ST")
	public void test2() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("ST Test cae 2");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();	}
	
	

	@Test(groups = "IT")//(enabled = false)
	public void test3() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("IT Test cae 3");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
}
