package annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	@BeforeMethod
	public void sampleBeforeMethodAnnotation()
	{
		System.out.println("sample Before Method Annotation");
	}
		
	@AfterMethod
	public void sampleAfterMethodAnnotation()
	{
		System.out.println("sample After Method Annotation");
	}
	
	@AfterClass
	public void sampleAfterClassAnnotationMethod()
	{
		System.out.println("sample After Class Annotation Method");
	}
	
	@BeforeClass
	public void sampleBeforeClassAnnotationMethod()
	{
		System.out.println("sample Befor Class Annotation Method");
	}
	
	@BeforeTest
	public void sampleBeforeTestAnnotationMethod()
	{
		System.out.println("sample before Test  Annotation Method");
	}
	
	@AfterTest
	public void sampleAfterTestAnnotationMethod()
	{
		System.out.println("sample after Test  Annotation Method");
	}

	@BeforeSuite
	public void sampleBeforeSuiteAnnotationMethod()
	{
		System.out.println("sample before suite  Annotation Method");
	}
	
	@AfterSuite
	public void sampleAfterSuiteAnnotationMethod()
	{
		System.out.println("sample after suite  Annotation Method");
	}

}
