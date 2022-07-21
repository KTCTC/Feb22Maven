package enable;

import org.testng.annotations.Test;

public class EnableInTestNG {
	
	@Test
	public void A()
	{
		System.out.println("Method A");
	}
	
	@Test (enabled = false)
	public void B()
	{
		System.out.println("Method B");
	}

}
