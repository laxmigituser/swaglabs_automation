package StepDefs;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import PageObjects.SuccessPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class StepDefinitions {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	SuccessPage successPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage= new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		successPage = new SuccessPage(driver);
	}
	
	@Given("User navigates-to {string} page")
	public void user_opens_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	@When("User enters {string} as username")
	public void enterUserName(String un) throws InterruptedException {
		loginPage.enterUserName(un);
		Thread.sleep(2000);
	}
	@And("User enters {string} as password")
	public void enterPassword(String pw) {
		loginPage.enterPassword(pw);
	}
	@And("User clicks on login button")
	public void clickLogin() {
		loginPage.clickOnLoginButton();
	}
	@Then("User verify page title should be {string}")
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue("Expected "+expectedTitle+" but found "+actualTitle, actualTitle.equals(expectedTitle));
	}
	@Then("User verify page URL includes {string}")
	public void verifyPageUrl(String expectedURL) {
		String actualURL=driver.getCurrentUrl();
		Assert.assertTrue(expectedURL+" not found in current URL", actualURL.contains(expectedURL));
	}
	
	// product page scripts
	
	@When("User add item to cart with name {string}")
	public void addItemToCart(String itemName) {
		String itemsXpath = "//div[@id='inventory_container']//div[@class='inventory_item']// div[text()='"+itemName+"']/following :: button";
		driver.findElement(By.xpath(itemsXpath)).click();
	}
	@Then("User verify cart count updated to {string}")
	public void verifyItemCount(String itemCount) {
		String cartItemCount = productsPage.getCartItemCount();
		Assert.assertEquals("Expected count is "+itemCount+" but found "+cartItemCount, cartItemCount, itemCount);
	}
	@Then("User clicks on cart Icon")
	public void clickCart() {
		productsPage.clickOnCartIcon();
	}
	
	//cart page script
	
	@And("User clicks on checkout button")
	public void clickCheckout() {
		cartPage.clickCheckOut();
	}
	@Then("User verify item with name {string} added in cart")
	public void verifycartItem(String itemName) {
		String itemXpath = "//div[@id='cart_contents_container']//div[@class='cart_list']//div[@class='cart_item']//div[@class='inventory_item_name' and text()='"+itemName+"']";
		driver.findElement(By.xpath(itemXpath)).isDisplayed();
	}
	
	//checkoutpage scripts
	
	@When("User enter firstname as {string}")
	public void enterFirstName(String fname) {
		checkOutPage.enterfName(fname);
	}
	@And("User enter lastname as {string}")
	public void enterLastName(String lname) {
		checkOutPage.enterlName(lname);
	}
	@And("User enter zipcode as {string}")
	public void enterZipCode(String zipcode) {
		checkOutPage.enterZipCode(zipcode);
	}
	@And("User clicks on continue button")
	public void clickContinue() {
		checkOutPage.clickContinue();
	}
	@And("User clicks finish button")
	public void clickFinish() throws InterruptedException {
		checkOutPage.clickFinishButton();
	}
	
	//success page scripts
	
	@Then("User verify that success message with complete text is displayed")
	public void assertSuccessMessage() {
		Assert.assertTrue("Success message not found", successPage.successMessageDisplayed()&successPage.successMessageSubTextDisplayed());
	}
	@And("User verify that success icon is displayed")
	public void assertSuccessIcon() {
		Assert.assertTrue("Success Icon not found", successPage.successLogo());
	}
	@And("User closes browser")
	public void close_browser() {
		driver.close();
		//driver.quit();
	}
}
