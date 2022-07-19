package annotation;

import org.testng.annotations.Test;

public class AnnotationInTestNG extends TestBase{

	@Test
	public void verifyUserCanLoginWithValidUserNameAndPassword()
	{
		System.out.println("verify User Can Login With Valid User Name And Password");
	}
	@Test
	public void verifyUserCanSendEmail()
	{
		System.out.println("verify User Can Send Email");
	}
	@Test
	public void verifyUserCanReadEmail()
	{
		System.out.println("verify User Can Read Email");
	}
	
	
}
