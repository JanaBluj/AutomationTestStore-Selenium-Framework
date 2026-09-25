package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginANewUser() {
		driver.get("https://automationteststore.com/index.php?rt=account/account");
		
		LoginPage loginPage = new LoginPage(driver);
	    
	    String uniqueID = String.valueOf(System.currentTimeMillis());
	    String dynamicEmail = "user" + uniqueID + "@gmail.com";
	    String dynamicUsername = "user" + uniqueID;
	    String dynamicPass = "Pass" + uniqueID;
	    
	    driver.findElement(By.id("accountFrm_accountregister")).click();
		driver.findElement(By.cssSelector(".btn.btn-orange.pull-right")).click();
	    loginPage.enterFullNameAndEmail("User","FirstLog",dynamicEmail);
		loginPage.AddressDetails("Um Uthaina", "Amman", "11183");
		loginPage.LoginDetails(dynamicUsername, dynamicPass);
		loginPage.Newsletter();
	    loginPage.LoginBTN();
	}
	
	public void SearchProduct(String product) {
		driver.findElement(By.id("filter_keyword")).sendKeys(product);
		driver.findElement(By.cssSelector("div[title='Go']")).click();
	}
	
	public String getSearchPageTitle() {
	    return driver.findElement(By.cssSelector(".maintext")).getText(); 
	}
	
	public void viewELDetails() {
		driver.findElement(By.xpath("//a[@title='Curls to straight Shampoo']")).click();
	}
	
	public void addItemToCart() {
		driver.findElement(By.xpath("//a[@class='cart']")).click();
	}
	
	public void viewCart() {
	    driver.get("https://automationteststore.com/index.php?rt=checkout/cart");
	}

	public void updateQuantity(String qty) {
	    WebElement quantityBox = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
	    quantityBox.clear();
	    quantityBox.sendKeys(qty);
	    
	    driver.findElement(By.xpath("//a[@class='btn btn-sm btn-default']")).click();
	}
	
	public void checkout() {
		driver.get("https://automationteststore.com/index.php?rt=checkout/cart");
		driver.findElement(By.id("cart_checkout1")).click();
	}
	
	public void OrderHistory() {
		driver.get("https://automationteststore.com/index.php?rt=account/history");
	}
	
	public void UserInfo(String FN, String LN) {
		driver.get("https://automationteststore.com/index.php?rt=account/account");
		driver.get("https://automationteststore.com/index.php?rt=account/edit");
		driver.findElement(By.id("AccountFrm_firstname")).sendKeys(FN);
		driver.findElement(By.id("AccountFrm_lastname")).sendKeys(LN);
		driver.findElement(By.cssSelector("button[title='Continue']")).click();
	}
	
	public String getSuccessMessage() {
	    WebElement successBox = driver.findElement(By.cssSelector(".alert.alert-success"));
	    return successBox.getText();
	}
	
	public void Newsletter(String email) {
		driver.findElement(By.id("appendedInputButton")).sendKeys(email);
		driver.findElement(By.cssSelector(".btn.btn-orange")).click();
		driver.findElement(By.id("imFrm_settingsnewsletteremail")).click();
		driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click")).click();
	}
	
	public void HoverAndSelectDropDownItem() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement mainMenu = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main_menu_top']/li[2]/a"))
		    );
		
		Actions action = new Actions(driver);
		action.moveToElement(mainMenu).perform();
		
		try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		WebElement subMenuItem = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a"));
	    subMenuItem.click();
	}
}
