package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ProductPage;

public class ProductTest {
	WebDriver driver;
	String URL = "https://automationteststore.com/";
	
	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	//Ensure that users can search for products using keywords
	@Test(priority = 1, enabled = true)
	public void searchEL() {
		ProductPage productpage = new ProductPage(driver);
		
		productpage.SearchProduct("shampoo");
		
		String searchResultText = productpage.getSearchPageTitle();
		
		Assert.assertTrue(searchResultText.contains("SEARCH"),
				"The search results do not match the expected product!");	
	}
	
	//Ensure that users can view detailed information about a product
	@Test(priority = 2, enabled = true)
	public void viewProductDetailsTest() {
		ProductPage productPage = new ProductPage(driver);
		
		productPage.SearchProduct("shampoo");
		productPage.viewELDetails();
		
		String pageTitle = driver.getTitle();
		System.out.println("Product Detail Page Title: " + pageTitle);
		
		Assert.assertTrue(pageTitle.contains("Curls to straight Shampoo"), 
				"The item didn't open and details did not appear!");
	}
	
	//Verify that users can add products to the shopping cart
	@Test(priority = 3, enabled = true)
	public void checkThatItemAddedSuccessfully() {
		ProductPage productPage = new ProductPage(driver);
		
		productPage.SearchProduct("shampoo");
		productPage.viewELDetails();
		productPage.addItemToCart();
		
		String pageTitle = driver.getTitle();
		System.out.println("checkout Page Title: " + pageTitle);
		
		Assert.assertTrue(pageTitle.contains("Shopping Cart"),"The item hasn't been adding to the cart");
	}
	
	//Ensure that users can view and modify their shopping cart
	@Test(priority = 4, enabled = true)
	public void checkShoppingCartItems() {
	    ProductPage productPage = new ProductPage(driver);
	   
        productPage.SearchProduct("shampoo");
	    productPage.viewELDetails();
	    productPage.addItemToCart();
	    productPage.viewCart();  

	    String pageTitle = driver.getTitle();
	    Assert.assertTrue(pageTitle.contains("Shopping Cart"), "The shopping cart page did not open!");
	}
	
	@Test(priority = 5, enabled = true)
	public void testUpdateQuantityAndRemove() {
	    ProductPage productPage = new ProductPage(driver);

	    productPage.SearchProduct("shampoo");
	    productPage.viewELDetails();
	    productPage.addItemToCart();
	    productPage.viewCart();
	    productPage.updateQuantity("2");
	    
	    String pageTitle = driver.getTitle();
	    Assert.assertTrue(pageTitle.contains("Shopping Cart"), "Quantity update failed!");
	}

	// Verify that users can proceed to the checkout process
	@Test(priority = 6, enabled = true)
	public void checkoutItems() {
	    ProductPage productPage = new ProductPage(driver);
	    
	    productPage.LoginANewUser();
	    
	    productPage.SearchProduct("shampoo");
	    productPage.viewELDetails();
	    productPage.addItemToCart();
	    
	    productPage.checkout();
	    
	    String pageTitle = driver.getTitle();
	    System.out.println("Current Page Title: " + pageTitle);
	    
	    Assert.assertTrue(pageTitle.contains("Checkout Confirmation"), "The checkout process failed");
	}
	
	//Verify that users can view their past orders
	@Test(priority = 7, enabled = true)
	public void viewOrders() {
		ProductPage PD = new ProductPage(driver);
		 
		    PD.LoginANewUser();
		    PD.SearchProduct("shampoo");
		    PD.viewELDetails();
		    PD.addItemToCart();
		    PD.checkout();
		    
		    PD.OrderHistory();
		
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("My Order History"), "Order history didn't appear");
	}
	
	//Managing Account Information
	@Test(priority = 8, enabled = true)
	public void ManagingAccountInformation() {
		driver.get("https://automationteststore.com/index.php?rt=account/account");
		
		ProductPage PD = new ProductPage(driver);
		
		PD.LoginANewUser();
	    PD.UserInfo("firstUser","Account");
	    
	    String successMsg = PD.getSuccessMessage();
	    
	    Assert.assertTrue(successMsg.contains("Success"), "The success message for managing user information did not appear!");	
	}
	
	//Ensure that users can subscribe to the newsletter
	@Test(priority = 9, enabled = true)
	public void SubscribeNewsletter() {
		ProductPage PD = new ProductPage(driver);
		
		PD.LoginANewUser();
		PD.Newsletter("user123@gmail.com");
		String SuccessMsg = PD.getSuccessMessage();
		
		Assert.assertTrue(SuccessMsg.contains("Success"), "The success message for newsletter did not appear!");
	}
	
	@Test(priority = 10, enabled = true)
	public void Logout() {
		ProductPage PD = new ProductPage(driver);
		
		PD.LoginANewUser();
		PD.HoverAndSelectDropDownItem();
		
		String PageTitle = driver.getTitle();
		Assert.assertTrue(PageTitle.contains("Account Logout"), "Logout failed");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) 
		{
			driver.quit();
		}
	}
}
