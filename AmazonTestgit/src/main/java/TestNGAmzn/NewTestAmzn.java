package TestNGAmzn;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTestAmzn {
	public WebDriver driver;
	static WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver1/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.navigate().to("https://www.amazon.in/");
	}

	@Test
	@Parameters("search")
	public void f(String search1) {
		wait = new WebDriverWait(driver, 10);
		WebElement searchd = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox']")));
		searchd.sendKeys(search1);
		WebElement search2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-search-submit-button']")));
		search2.click();
		WebElement kajal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@alt='Sponsored Ad - Lakme Eyeconic Black Kajal 0.35 g (Combo Pack of 2) Matte Kohl Liner in a Twist Up Pencil - Waterproof, Smu...']")));
		kajal.click();
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		Actions actions = new Actions(driver);
		WebElement cart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add to Cart']")));
		actions.click(cart).perform();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
