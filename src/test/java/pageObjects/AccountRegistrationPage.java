package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage  extends BasePage{
	
	//1. Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//2.Locators
	@FindBy(id="input-firstname")
	WebElement txt_firstName;
	
	@FindBy(id="input-lastname")
	WebElement txt_lastName;
	
	@FindBy(id="input-email")
	WebElement txt_email;
	
	@FindBy(id="input-telephone")
	WebElement txt_telephone;
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(id="input-confirm")
	WebElement txt_confirm;
	
	@FindBy(xpath="//input[@type='checkbox' and  @name='agree']")
	WebElement chk_policy;
	
	@FindBy(xpath="//input[@type='submit' and @value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	//Action Methods
	
	public void firstName(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
   
	public void lastName(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	public void email(String email)
	{
		txt_email.sendKeys(email);
	}
	public void telephone(String tel)
	{
		txt_telephone.sendKeys(tel);
	}
	public void password(String pass)
	{
		txt_password.sendKeys(pass);
	}
	public void confirmPassword(String conpass)
	{
		txt_confirm.sendKeys(conpass);
	}
	
	public void checkPolicy()
	{
		chk_policy.click();
	}
	
	public void clickContinue()
	{   //sol-1
		btn_continue.click();
		
		//sol-2
		/*btn_continue.submit();
		//sol-3
		Actions action = new Actions(driver);
		action.moveToElement(btn_continue).build().perform();
		
		//sol-4 (To resolve element intercepted error)
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("argument[0].click", btn_continue);
		
		//sol-5
		btn_continue.sendKeys(Keys.RETURN);
		
		//sol-6
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
		*/
		
		
	}
	
	public String getConfirmationMsg()
	{

		try
		{   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String str =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))).getText();
			return str;
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
