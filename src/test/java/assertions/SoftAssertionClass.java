package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import anno.AnnoClass;

public class SoftAssertionClass {
	AnnoClass obj = new AnnoClass();
	
	@Test
	public void verifyUserCanLoginWithValidUserNameAndPassword()
	{
		System.out.println("verify User Can Login With Valid User Name And Password");
		SoftAssert sAssert = new SoftAssert();
		boolean flag = false;
		boolean flag1 = true;
		boolean flag2 = true;		
		sAssert.assertTrue(flag, "User name is not displayed");
		sAssert.assertTrue(flag1, "Compose mail button is not displayed");
		sAssert.assertFalse(flag2, "deleted user is displayed");
		
		System.out.println("Hello after assertion");
		sAssert.assertAll();
	}
	@Test
	public void verifyUserCanSendEmail()
	{
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verify User Can Send Email");
		sAssert.assertEquals(23, 45, "values is not matching");
		sAssert.assertNotEquals("i file uploaded", "1 file uploaded successfully");
		
		System.out.println("after equality soft assert");
		sAssert.assertAll();
	}
	@Test
	public void verifyUserCanReadEmail()
	{
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verify User Can Read Email");		
		sAssert.assertNull(obj);
		sAssert.assertNotNull(obj);
		System.out.println("after null soft assertion");
		sAssert.assertAll();
		
	}
	
	

}
