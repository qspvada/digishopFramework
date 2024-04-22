package testNgBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(groups = "ST")
	public void login_001() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("ST login_001");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(groups = "RT")
	public void login_002() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Reporter.log("RT login_002");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//driver.get("dfghjkl;");
		driver.quit();
	}
}
