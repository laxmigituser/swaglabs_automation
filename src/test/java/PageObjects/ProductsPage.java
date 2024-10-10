package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath = "//div[@id='header_container']//a[contains(@class,shopping_cart_link)]//span")
	WebElement cartItemsCount;
	@FindBy(xpath = "//div[@id='header_container']//a[contains(@class,shopping_cart_link)]")
	WebElement cartIcon;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getCartItemCount()
	{
		return cartItemsCount.getText();
	}

	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
}
