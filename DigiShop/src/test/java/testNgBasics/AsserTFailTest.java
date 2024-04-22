package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AsserTFailTest {

	@Test
	public void electronic() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement cellPhoneLink=driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href=\"/cell-phones\"]"));
		Thread.sleep(3000);
		
		//Assert.assertEquals(cellPhoneLink.isDisplayed(), false,"Cell phone link is displayed");
	
		Assert.assertFalse(cellPhoneLink.isDisplayed(), "Cell phone link is displayed");
		
		
		Assert.fail();
		
		Reporter.log("Test case completed",true);
	
		driver.quit();
	}
}
