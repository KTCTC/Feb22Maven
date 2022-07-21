package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import anno.AnnoClass;

public class AssertionClass {
	AnnoClass obj = new AnnoClass();
	
	@Test
	public void verifyUserCanLoginWithValidUserNameAndPassword()
	{
		System.out.println("verify User Can Login With Valid User Name And Password");
		
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = false;		
		Assert.assertFalse(flag2, "user is displayed even after deletion");
		Assert.assertTrue(flag, "User profile name is not displayed");
		Assert.assertTrue(flag1, "compose mail button is not displayed");

		
		System.out.println("Hello after assertion");
	}
	@Test
	public void verifyUserCanSendEmail()
	{
		System.out.println("verify User Can Send Email");
		Assert.assertNull(obj);
		Assert.assertNotNull(obj, "OBJECT IS NOT INITIALISED");
		System.out.println("after null assertion");
	}
	@Test
	public void verifyUserCanReadEmail()
	{
		System.out.println("verify User Can Read Email");
		
		Assert.assertNotEquals(444, 567);
		
		Assert.assertEquals("1 file uploaded succussfully", "1 file uploaded succussfully");
		
		float cntSharePrice = 405.55f;		
		
		Assert.assertEquals(cntSharePrice, "405.55", "Current share price is not matching");
		
		System.out.println("after equal assertion");
		
	}
	
	@Test
	public void verifyuserslist()
	{
		Assert.assertTrue(true);
		Assert.assertEquals(23, 45);
		Assert.assertNotNull(obj);
		
	}

}
