package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    
	//1. Constructor
	public HomePage(WebDriver driver) {
		super(driver); // This will invoke parent class constructor
	}
   
	//2.Locators
	@FindBy(xpath="//span[text() ='My Account']")
	WebElement lnk_MyAccount;
	
	@FindBy(xpath="//a[text() ='Register']")
	WebElement lnk_Register;
	
	@FindBy(linkText="Login")
	WebElement lnk_Login;
	
	//3.Action Methods
	
	public void clickMyAccount()
	{
		lnk_MyAccount.click();
	}
	
	public void clickRegister()
	{
		lnk_Register.click();
	}
	
	public void clickLogin()
	{
		lnk_Login.click();
	}
}
