package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verfy_login() {
		logger.info("***** This is excution started for TC002_LoginTest *****");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Clicked on My Account  ");
			hp.clickMyAccount();
			logger.info("Clicked on Login  ");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			logger.info("Provided Login details  ");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage my = new MyAccountPage(driver);
			logger.info("Check if My Account Exists  ");
			boolean status = my.isMyAccountPageExist();
			Assert.assertTrue(status);
			
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** This is excution completed for TC002_LoginTest *****");
	}

}
