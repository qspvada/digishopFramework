package testCripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import objectrRepository.BookPage;
import objectrRepository.HomePage;



@Listeners(listenerUtility.ListenerImpl.class)
public class BooksTest extends BaseClass {

	@Test
	public void book_001() {
		//Click on Books link
		driver.findElement(By.linkText("COMPUTER")).click();
		test.log(LogStatus.INFO,"To click on Books", "Clicked on Books link");
		
		String actualPageTitle=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		
		try {
		//Verfiy the Books page is displayed
		Assert.assertEquals(actualPageTitle, "Books", "Books page is not displayed");
		test.log(LogStatus.PASS, "Book page is displayed");
		}
		catch (AssertionError e) {
			test.log(LogStatus.FAIL,"Books page not displayed", test.addScreenCapture(getWebPageScreenshot(driver)));
		}
		
		Reporter.log("test case completed",true);
	}
	
	@Test
	public void book_002() {
		//Click on Books link
		driver.findElement(By.linkText("BOOKS")).click();
		test.log(LogStatus.INFO, "Clicked on Books link");
		boolean actualResult=driver.findElement(By.id("products-orderby")).isDisplayed();
		
		//Verfiy the Books page is displayed
		Assert.assertEquals(actualResult, true, "Sort by dropdown is not displayed");
		test.log(LogStatus.PASS, "Sort by dropdown is displayed");
		Reporter.log("test case completed",true);
	}
	

//	@Test
//	public void book_003() throws InterruptedException {
//		HomePage homePage=new HomePage(driver);
//		BookPage bookpage=new BookPage(driver);
//		//Click on Books link
//		homePage.getBooksLink().click();
//		
//		selectOptionByIndex(bookpage.getSortByDropdown(), 2);
//		
//		selectOptionByVisibletext(bookpage.getDisplayDropdown(), "12");
//		
//		selectOptionByVisibletext(bookpage.getViewAsDropdown(),"List");
//		Thread.sleep(3000);
//	}
//	
//	@Test
//	public void book_004() {
//		//Switch to Flipkart window
//		switchToWindowByTitle(driver, "flipkart");
//		
//		//Close Flipkart window
//		driver.close();
//		
//		//Switch to Amazon window
//		switchToWindowByUrl(driver, "amazon.com");
//		
//		//Maximize Amazon window
//		driver.manage().window().maximize();
//		driver.close();
//	}
	
	
	
}
