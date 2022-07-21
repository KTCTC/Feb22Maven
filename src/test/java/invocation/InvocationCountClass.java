package invocation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvocationCountClass {
	int count=0;
	
	@Test (invocationCount = 5)
	public void verifyUserCanSendEmail()
	{
		System.out.println("verify User Can Send Email");
		count++;
		if (count==3)
		{
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
		
	}
	
	@Test (dependsOnMethods = "verifyUserCanSendEmail")
	public void sample()
	{
		System.out.println("Sample test case");
	}

}
