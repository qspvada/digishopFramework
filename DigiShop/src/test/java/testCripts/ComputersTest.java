package testCripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class ComputersTest extends BaseClass {

	@Test
	public void computers_001() {
		// Click on Computers link
		driver.findElement(By.linkText("COMPUTERS")).click();

		String actualPageTitle = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();

		// Verfiy the Computers page is displayed
		Assert.assertEquals(actualPageTitle, "Computers", "Computers page is not displayed");

		Reporter.log("test case completed", true);
	}
	
	
	@Test 
	public void computers_002() {
		//Click on Computers link
		driver.findElement(By.linkText("COMPUTERS")).click();
		
		//verify the computers page is displayed or not
		boolean actualResult=driver.findElement(By.linkText("Desktops")).isDisplayed();
		
		Assert.assertTrue(actualResult,"Desktops is not displayed");
		
		Reporter.log("test case is completed");
	}
}
