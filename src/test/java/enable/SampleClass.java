package enable;

import org.testng.annotations.Test;

public class SampleClass {
	@Test //(enabled = false)
	public void method1() 
	{
		System.out.println("Method1");
	}
	@Test
	public void method2() 
	{
		System.out.println("Method2");
	}
	@Test(dependsOnMethods = {"method5"})
	public void method3() 
	{
		System.out.println("Method3");
		
	}
	@Test
	public void method4() 
	{
		System.out.println("Method4");
	}
	@Test
	public void method5() 
	{
		System.out.println("Method5");
	}


}
