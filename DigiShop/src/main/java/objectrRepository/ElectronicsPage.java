package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends BasePage {

	public ElectronicsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//img[@alt='Picture for category Cell phones']")
	private WebElement cellPhoneLink;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getCellPhoneLink() {
		return cellPhoneLink;
	}
}
