package testCripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import objectrRepository.HomePage;
import objectrRepository.JewelryPage;

public class JewelryTest extends BaseClass {

	@Test
	public void jewelry_001() {
	HomePage homePage=new HomePage(driver);
	JewelryPage jewelryPage=new JewelryPage(driver);
	//Click on Jewelry link
	homePage.getJewelryLink().click();
	
	try {
	Assert.assertEquals(jewelryPage.getPageTitle().getText(), "Jewelry");
	getWebPageScreenshot(driver);
	}
	
	catch (AssertionError e) {
		getWebPageScreenshot(driver);
	}
	
//	scrollIntoElementView(driver, jewelryPage.getBlackAndWhiteDiamondHeart(), true);
//	
//	//Take Heart screenshot
//	getWebElementScreenshot(jewelryPage.getBlackAndWhiteDiamondHeart());
	
	//take add to cart screenshot
	getWebElementScreenshot(jewelryPage.getAddHeartToCartButton());
	
	//Click on Shopping cart link
	homePage.getShoppingcartLink().click();
	
	//Take screenshot of Shopping cart page
	getWebPageScreenshot(driver);
	
	}
}
