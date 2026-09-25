package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Fill Name field and email field
	public void enterFullNameAndEmail(String fName, String lName, String email) {
		driver.findElement(By.id("AccountFrm_firstname")).sendKeys(fName);
		driver.findElement(By.id("AccountFrm_lastname")).sendKeys(lName);
		driver.findElement(By.id("AccountFrm_email")).sendKeys(email);
	}
	
	//Address Details
	public void AddressDetails(String Add1, String city, String zipCode) {
	    driver.findElement(By.id("AccountFrm_address_1")).sendKeys(Add1);
	    driver.findElement(By.id("AccountFrm_city")).sendKeys(city);
	    driver.findElement(By.id("AccountFrm_postcode")).sendKeys(zipCode);
	    
	    WebElement Country = driver.findElement(By.id("AccountFrm_country_id"));
	    Select myCountry = new Select(Country);
	    myCountry.selectByVisibleText("Jordan");
	    
	    try {
	        Thread.sleep(1500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	     
	    WebElement region = driver.findElement(By.id("AccountFrm_zone_id"));
	    Select selectRegion = new Select(region);
	    selectRegion.selectByVisibleText("'Amman");
	}
	
	//Login enter the user name and password
	public void LoginDetails(String LoginName, String Password) {
		driver.findElement(By.id("AccountFrm_loginname")).sendKeys(LoginName);
		driver.findElement(By.id("AccountFrm_password")).sendKeys(Password);
		driver.findElement(By.id("AccountFrm_confirm")).sendKeys(Password);
	}
	
	//radiobutton and checkbox
	public void Newsletter() {
		driver.findElement(By.id("AccountFrm_newsletter0")).click();
		driver.findElement(By.id("AccountFrm_agree")).click();
	}
	
	//click the login button
	public void LoginBTN() {
		driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click")).click();
	}
	
	//login section
	public void ReturningCustomer(String LoginName, String Password) {
		driver.findElement(By.id("loginFrm_loginname")).sendKeys(LoginName);
		driver.findElement(By.id("loginFrm_password")).sendKeys(Password);
		driver.findElement(By.cssSelector(".btn.btn-orange.pull-right")).click();
	}
}
