package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "img[alt='Tricentis Demo Web Shop']")
	private WebElement logo;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(partialLinkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchField;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;
	
	@FindBy(linkText = "Electronics")
	private WebElement elctronicsLink;
	
	@FindBy(linkText = "JEWELRY")
	private WebElement jewelryLink;
	
	@FindBy(partialLinkText =   "Shopping")
	private WebElement shoppingcartLink;
	
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	
	@FindBy(css = "[alt='Picture of 14.1-inch Laptop']")
	private WebElement lapTopImage;
	
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getLapTopImage() {
		return lapTopImage;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getShoppingcartLink() {
		return shoppingcartLink;
	}

	public WebElement getJewelryLink() {
		return jewelryLink;
	}

	public WebElement getElctronicsLink() {
		return elctronicsLink;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
}
