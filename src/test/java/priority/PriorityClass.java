package priority;

import org.testng.annotations.Test;

public class PriorityClass {
	@Test (priority = 1, dependsOnMethods = "verifyExistingUserCanBeDeleted")
	public void verifyNewUserCanBeadded()
	{
		System.out.println("verifyNewUserCanBeadded");
	}
	@Test (priority = 2)
	public void verifyExistingUserCanBeedited()
	{
		System.out.println("verifyExistingUserCanBeedited");
	}
	@Test (priority = 3)
	public void verifyExistingUserCanBeDeleted()
	{
		System.out.println("verifyExistingUserCanBeDeleted");
	}
	

}
