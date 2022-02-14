package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageAmzn {
	public WebDriver driver;

	public HomepageAmzn(WebDriver driver)
	{
		this.driver = driver;
	}

	By searchbox = By.xpath("//*[@id='twotabsearchtextbox']");
	By submitbutton = By.xpath("//*[@id='nav-search-submit-button']");
	By productpurchase = By.xpath("//*[@alt='Sponsored Ad - Lakme Eyeconic Black Kajal 0.35 g (Combo Pack of 2) Matte Kohl Liner in a Twist Up Pencil - Waterproof, Smu...']");

	public void searchAmazon(String searchinput) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);
		WebElement we1 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		actions.click(we1).perform();
		
		WebElement we2=wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		we2.sendKeys(searchinput);
		WebElement we3=wait.until(ExpectedConditions.visibilityOfElementLocated(submitbutton));
		we3.click();
	}
	public void selectProduct() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement we4=wait.until(ExpectedConditions.visibilityOfElementLocated(productpurchase));
		we4.click();
	}
}

