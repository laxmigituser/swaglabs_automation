package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userNameIPBox;
	
	@FindBy(id = "password")
	WebElement passwordIPBox;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String un)
	{
		userNameIPBox.sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		passwordIPBox.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		loginBtn.click();
	}
}
