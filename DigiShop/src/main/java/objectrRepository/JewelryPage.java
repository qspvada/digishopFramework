package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JewelryPage extends BasePage{

	public JewelryPage(WebDriver driver) {
	super(driver);
	}
	
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//a[.='Black & White Diamond Heart']/../..//input")
	private WebElement addHeartToCartButton;
	
	@FindBy(xpath = "//a[.='Black & White Diamond Heart']/../../../..")
	private WebElement blackAndWhiteDiamondHeart;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getAddHeartToCartButton() {
		return addHeartToCartButton;
	}

	public WebElement getBlackAndWhiteDiamondHeart() {
		return blackAndWhiteDiamondHeart;
	}
}
