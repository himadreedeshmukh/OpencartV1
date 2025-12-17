package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid —>Login successful —>Passed  —>logout
Data is valid —>Login unsuccessful —>Failed

Data is invalid —>Login successful —>Failed  —>logout
Data is invalid —>Login unsuccessful —>Passed
*/

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= "Datadriven") //Getting DataProvider from different class
	public void verify_loginDDT(String email, String pass, String exp)
	{logger.info("***** This is excution started for TC003_LoginDDT *****");
	try {
		HomePage hp = new HomePage(driver);
		logger.info("Clicked on My Account  ");
		hp.clickMyAccount();
		logger.info("Clicked on Login  ");
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		logger.info("Provided Login details  ");
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.clickLogin();

		MyAccountPage my = new MyAccountPage(driver);
		logger.info("Check if My Account Exists  ");
		boolean targetPage = my.isMyAccountPageExist();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{   
				my.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{   my.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e)
	{
		Assert.fail();
	}
		logger.info("***** This is excution finished for TC003_LoginDDT *****");
		}
	
}
