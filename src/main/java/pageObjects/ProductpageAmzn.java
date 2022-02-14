package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductpageAmzn {
	public WebDriver driver;

	public ProductpageAmzn(WebDriver driver) {
		this.driver = driver;
	}

//	By productpurchase = By.xpath(
//			"//*[@alt='Sponsored Ad - Lakme Eyeconic Black Kajal 0.35 g (Combo Pack of 2) Matte Kohl Liner in a Twist Up Pencil - Waterproof, Smu...']");
//}
    By addtocart=By.xpath("//*[text()='Add to Cart']");

	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we5 = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));
		js.executeScript("arguments[0].scrollIntoView();", we5);
		we5.click();
	}
}
