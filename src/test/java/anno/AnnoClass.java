package anno;

import org.testng.annotations.Test;

import annotation.TestBase;

public class AnnoClass extends TestBase{
	@Test
	public void A()
	{
		System.out.println("Method A");
	}
	
	@Test
	public void B()
	{
		System.out.println("Method B");
	}

}
