package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BasePage {

	public BookPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "products-orderby")
	private WebElement sortByDropdown;
	
	@FindBy(id = "products-pagesize")
	private WebElement displayDropdown;
	
	@FindBy(id = "products-viewmode")
	private WebElement viewAsDropdown;

	public WebElement getSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}

	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}
	
	
	
}
