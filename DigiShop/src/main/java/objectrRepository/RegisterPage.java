package objectrRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FirstName")
	private WebElement firstName;
	
	@FindBy(id = "LastName")
	private WebElement lastName;
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	@FindBy(id = "Email")
	private WebElement emailTF;
	
	@FindBy(id = "Password")
	private WebElement passwordTF;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;
}
