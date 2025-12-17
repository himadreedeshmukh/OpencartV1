package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// 1.constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// 2.Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement header_myaccount;
	
//	@FindBy(xpath="//nav[@id='top']")
//	WebElement dp_user;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnk_logout;

	// 3.Action Methods
	public boolean isMyAccountPageExist() {
		try {
		return(header_myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{    //dp_user.click();
		lnk_logout.click();
	}
}

