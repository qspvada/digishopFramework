package testCripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectrRepository.CellPhonePage;
import objectrRepository.ElectronicsPage;
import objectrRepository.HomePage;

public class ElectronicsTest extends BaseClass{

	@Test
	public void electronics_cellPhone_001() throws InterruptedException {
	
		HomePage homePage=new HomePage(driver);
		ElectronicsPage electronicsPage=new ElectronicsPage(driver);
		CellPhonePage cellPhonePage=new CellPhonePage(driver);
		//Click on Electronics link
		homePage.getElctronicsLink().click();
		
		//Verify Electronics page is displayed
		Assert.assertEquals(electronicsPage.getPageTitle().getText(), "Electronics","Electronics page is not dispalyed");
		
		//Click on Cell phone link
		electronicsPage.getCellPhoneLink().click();
		
		//Verfiy Cell phone page is displayed
		Assert.assertEquals(cellPhonePage.getPageTitle().getText(), "Cell phones","Cell phone page is not displayed");
		
		//Sort the options by Name A to Z
		Select select=new Select(cellPhonePage.getSortByDropDown());
		select.selectByIndex(1);
		
		//Sort the options by name Z to A
		select.selectByIndex(2);
		
		
		
		//Sort the options by Name A to Z
//		WebElement dropdown=driver.findElement(By.id("products-orderby"));
//		Select select=new Select(dropdown);
//		
//		select.selectByIndex(1);
//		Thread.sleep(2000);
//		dropdown=driver.findElement(By.id("products-orderby"));
//		select=new Select(dropdown);
//		//Sort the options by name Z to A
//		select.selectByIndex(2);
		
		
	}
}
