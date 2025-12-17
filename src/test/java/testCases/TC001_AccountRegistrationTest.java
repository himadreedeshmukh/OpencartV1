package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
  @Test(groups= {"Regression","Master"})
  public void verify_account_registration() throws InterruptedException 
  {   logger.info("***** This is excution started for TC001_AccountRegistrationTest *****");
  try {
	  HomePage hp = new HomePage(driver);
	  logger.info("Clicked on My Account  ");
	  hp.clickMyAccount();
	  logger.info("Clicked on Register  ");
	  hp.clickRegister();
	  
	  
	  AccountRegistrationPage reg = new AccountRegistrationPage(driver);
	  logger.info("Provided Registration details  ");
	  reg.firstName(randomString().toUpperCase());
	  reg.lastName(randomString().toUpperCase());
	  reg.email(randomString()+"@gmail.com");
	  reg.telephone(randomNumber());
	  String password = randomAlpaNumeric(); //get the random alphanumeric string and password generated stored in string and the passed to password and confirm password field
	  reg.password(password);
	  reg.confirmPassword(password);
	  reg.checkPolicy();
	  reg.clickContinue();
	  
	  logger.info("Validating the Confirmation message  ");
      String confirmMsg =reg.getConfirmationMsg();
	  System.out.println(confirmMsg);
	  if(confirmMsg.equals("Your Account Has Been Created!"))
	  {
		  AssertJUnit.assertTrue(true);
	  }
	  else
	  {
		  logger.error("Test Failed");
		  logger.debug("Debug logs"); 
		  AssertJUnit.assertTrue(false);
	  }
	 // Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
  }
  catch(Exception e)
  {
	 
	  Assert.fail();
  }
  }
  
}
