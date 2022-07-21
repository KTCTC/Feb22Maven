package dependend.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentTestCasesClass {
	
	@Test 
	public void verifyUserCanLoginWithValidUserNameAndPassword()
	{
		System.out.println("verify User Can Login With Valid User Name And Password");
		Assert.assertTrue(true);
	}
	@Test (dependsOnMethods = "verifyUserCanLoginWithValidUserNameAndPassword")
	public void verifyUserCanSendEmail()
	{
		System.out.println("verify User Can Send Email");
		Assert.assertTrue(false);
	}
	@Test (dependsOnMethods = "verifyUserCanSendEmail")
	public void verifyUserCanReadEmail()
	{
		System.out.println("verify User Can Read Email");
	}

}
