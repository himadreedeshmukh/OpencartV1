package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//1.constructor
    public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
    //2.Locators
	@FindBy(id="input-email")
	WebElement txt_emailadd;
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	
    //3.Action Methods
	public void setEmail(String email)
	{
		txt_emailadd.sendKeys(email);
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	public void clickLogin()
	{
		btn_login.click();
	}
}
