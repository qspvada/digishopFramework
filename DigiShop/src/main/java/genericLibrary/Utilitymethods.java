package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Utilitymethods implements FrameworkConstants{
	
	static JavascriptExecutor jse;
	static Actions action;
	static TakesScreenshot ts;

	public static String getWebPageScreenshot(WebDriver driver) {
		
		String imagePath=SCREENSHOT_PATH+ getTime() + ".png";
		
//		// Step 1: Convert WebDriver reference into TakesScreenshot tupe
//		TakesScreenshot ts = (TakesScreenshot) driver;

		// Step 2: Get the screenshot and store in temp variable
		File temp = ts.getScreenshotAs(OutputType.FILE);

		// Step 3: Craete a permanent File location
		File permanent = new File(imagePath);

		// Step 4: Copy paste the image from temp to permanent location
		try {
			FileHandler.copy(temp, permanent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "."+imagePath;
	}

	public static String getWebElementScreenshot(WebElement element) {
		
		
		String imagePath=SCREENSHOT_PATH + getTime() + ".png";
		//Get the screenshot and store in Temp location
		File temp = element.getScreenshotAs(OutputType.FILE);

		// Step 2: Craete a permanent File location
		File permanent = new File(imagePath);

		// Step 3: Copy paste the image from temp to permanent location
		try {
			FileHandler.copy(temp, permanent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "."+imagePath;
	}

	
	public static void scrollIntoElementView(WebElement element,boolean position) {
		
		jse.executeScript("arguments[0].scrollIntoView("+position+")", element);
		
	}
	
	
	public static void scrollBy( int x, int y) {
		
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public static void scrollTo( int x, int y) {
		
		jse.executeScript("window.scrollTo("+x+","+y+")");
	}
	
	public static void handleDisabledOrHiddenTextFiled(WebElement element,String value) {
		jse.executeScript("arguments[0].value='"+value+"'", element );
	}
	
	public static void handleHiddenOrDisabledbutton( WebElement element) {
		
		jse.executeScript("arguments[0].click()", element);
	}
	
	public static void mouseHover(WebElement element) {
		action.moveToElement(element).perform();
	}
	
	public static void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	
	public static void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}
	
	public static void clickAndHold(WebElement element) {
		action.clickAndHold(element).perform();
	}
	
	public static void release(WebElement element) {
	action.release(element).perform();	
	}
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target).perform();
	}
	
	public static void scrollByAmount(int x, int y) {
		action.scrollByAmount(x, y).perform();
	}
	
	public static void scrollToElement(WebElement element) {
		action.scrollToElement(element).perform();
	}
	
	public static void scrollFromOrigin(WebElement element, int x, int y) {
		ScrollOrigin origin=ScrollOrigin.fromElement(element);
		action.scrollFromOrigin(origin, x, y).perform();
	}
	
	public static void keyPress(Keys key) {
		action.keyDown(key).perform();
	}
	
	public static void keyRelease(Keys key) {
		action.keyUp(key).perform();
	}
	
	public static void initObjects(WebDriver driver) {
	jse=(JavascriptExecutor) driver;
	action=new Actions(driver);
	ts=(TakesScreenshot) driver;
	}
	
	public static String getTime() {
		return LocalDateTime.now().toString().replace("-", "_").replace(":", "_");
	}
	
	
	public static void selectOptionByIndex(WebElement dropdown,int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public static void selectOptionByValue(WebElement dropdown,String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
	}
	
	public static void selectOptionByVisibletext(WebElement dropdown,String text) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	public static void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window:allWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
	}
	
	
	public static void switchToWindowByUrl(WebDriver driver, String url) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window:allWindows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}
	
	
	
	
}
