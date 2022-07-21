package dependend.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentTestCasesClass2 {
	
	@Test
	public void verifyUserCanLoginWithValidUserNameAndPassword()
	{
		System.out.println("verify User Can Login With Valid User Name And Password");
		Assert.assertTrue(false);
	}
	@Test 
	public void verifyUserCanSendEmail()
	{
		System.out.println("verify User Can Send Email");
		Assert.assertTrue(true);
	}
	@Test (dependsOnMethods = {"verifyUserCanSendEmail","verifyUserCanLoginWithValidUserNameAndPassword"}, enabled = false)
	public void verifyUserCanReadEmail()
	{
		System.out.println("verify User Can Read Email");
	}

}
