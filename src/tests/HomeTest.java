package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

//Verify that the homepage loads successfully without errors
public class HomeTest {
	WebDriver driver;
	String URL = "https://www.automationteststore.com/";
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testHomePageLoad() {
		HomePage homePage = new HomePage(driver);
		
		String actualTitle = homePage.getPageTitle();
        String expectedTitle = "A place to practice your automation skills!";
        
        Assert.assertEquals(actualTitle, expectedTitle, "Homepage failed to load properly!");
	}
	
	@AfterMethod
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
