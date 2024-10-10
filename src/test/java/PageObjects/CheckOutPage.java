package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement fnameIPBox;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lnameIPBox;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//a[text()='FINISH']")
	WebElement finishBtn;
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterfName(String fname) {
		fnameIPBox.sendKeys(fname);
	}
	public void enterlName(String lname) {
		lnameIPBox.sendKeys(lname);
	}
	public void enterZipCode(String zipcode) {
		postalCode.sendKeys(zipcode);
	}
	public void clickContinue() {
		continueBtn.click();
	}
	public void clickFinishButton() {
		finishBtn.click();
	}
	
}
