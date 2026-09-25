package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;


// Ensure that new users can register an account
//Verify that registered users can log in successfully
public class LoginTest {
	WebDriver driver;
	String URL = "https://automationteststore.com/index.php?rt=account/login";
	
	String uniqueID = String.valueOf(System.currentTimeMillis());
    String dynamicEmail = "user" + uniqueID + "@gmail.com";
    String dynamicUsername = "user" + uniqueID;
    String dynamicPass = "Pass" + uniqueID;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test(priority = 1)
	public void Regestration() {
		driver.findElement(By.id("accountFrm_accountregister")).click();
		driver.findElement(By.cssSelector(".btn.btn-orange.pull-right")).click();
		 
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterFullNameAndEmail("User","FirstLog",dynamicEmail);
		loginPage.AddressDetails("Um Uthaina", "Amman", "11183");
		loginPage.LoginDetails(dynamicUsername, dynamicPass);
		loginPage.Newsletter();
	    loginPage.LoginBTN();
	    
	    driver.get("https://automationteststore.com/index.php?rt=account/logout");
       
        driver.get("https://automationteststore.com/index.php?rt=account/login");
         
        LoginPage returnCus = new LoginPage(driver);
        returnCus.ReturningCustomer(dynamicUsername, dynamicPass);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) 
		{
			driver.quit();
		}
	}
}
