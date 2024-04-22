package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPhonePage extends BasePage {

	public CellPhonePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	private WebElement pageTitle;
	
	@FindBy(id = "products-orderby")
	private WebElement sortByDropDown;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}
}
