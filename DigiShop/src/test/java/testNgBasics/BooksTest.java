package testNgBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BooksTest {

	@Test
	public void book_001() {
		//Launch browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Navigate to URl
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click on BOOKS link
		driver.findElement(By.linkText("COMPUTERS")).click();
		
		String actualTitle = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		String expectedTitle="Books";
		
		//HardAssert
//		Assert.assertEquals(actualTitle, expectedTitle);
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle,"Books page is not displayed");
		
		
		driver.quit();
		Reporter.log("Test case completed",true);
		
		soft.assertAll();
	}
}
