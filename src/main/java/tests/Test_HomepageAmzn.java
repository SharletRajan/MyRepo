package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomepageAmzn;
import pageObjects.ProductpageAmzn;

public class Test_HomepageAmzn {
	WebDriver driver;
	HomepageAmzn objectrepo;
	
	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@Test
	@Parameters("search")
	public void HomePageOperation1(String search) {
		HomepageAmzn  page1=new HomepageAmzn (driver);
		page1.searchAmazon(search);
	}
	
	@Test
	public void HomePageOperation2() {
//		AmazonHomePage page2=new AmazonHomePage(driver);
//		page2.selectProduct();
		objectrepo=new HomepageAmzn(driver);
		objectrepo.selectProduct();
	}
	
	@Test
	public void addToCartOperation() {
		ProductpageAmzn page2=new ProductpageAmzn(driver);
		page2.addToCart();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}

