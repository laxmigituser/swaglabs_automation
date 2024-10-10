package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

	@FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement successMessage;
	@FindBy(xpath = "//div[@class='complete-text']")
	WebElement successMessage_subtext;
	@FindBy(xpath = "//img[@class='pony_express']")
	WebElement successLogo;
	
	public SuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean successMessageDisplayed() {
		return successMessage.isDisplayed();
	}
	public boolean successMessageSubTextDisplayed() {
		return successMessage_subtext.isDisplayed();
	}
	public boolean successLogo() {
		return successLogo.isDisplayed();
	}
	
	
}
