package testCripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.ExcelUtility;
import objectrRepository.HomePage;

public class HomeTest extends BaseClass {

	@Test
	public void home_001() {
		HomePage homePage=new HomePage(driver);
		
		//Enter the product name
		homePage.getSearchField().sendKeys("laptop");
		
		//Click on Search button
		homePage.getSearchButton().click();
	}
	
	
	@Test
	public void home_002() throws InterruptedException {
		
		HomePage homePage=new HomePage(driver);
		scrollToElement(homePage.getLapTopImage());
		Thread.sleep(3000);
	}
	
	
	@Test
	public void home_003() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		
		scrollFromOrigin(homePage.getLapTopImage(), 0, 300);
	
		Thread.sleep(5000);
		
		scrollFromOrigin(homePage.getLapTopImage(), 0, -500);
		Thread.sleep(5000);
	}
	
	@Test(dataProvider = "pdata")
	public void home_004(String product) throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		//Search for the product
		homePage.getSearchField().sendKeys(product);
		Thread.sleep(1000);
		
		//Click on Seacrh button
		homePage.getSearchButton().click();
		
	}
	
	
	@DataProvider(name = "pdata")
	public String[][] productData(){
		return ExcelUtility.readRowData("Products");
	}
	
}
