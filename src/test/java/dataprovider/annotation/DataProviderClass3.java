package dataprovider.annotation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.ExcelHelper;

public class DataProviderClass3 {
	
@BeforeClass
public void beforeClassMethod()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.get("https://demoqa.com/text-box");
	driver.navigate().to("https://demoqa.com/webtables");
	
	}
	
	@DataProvider (name = "userdata")
	public Object[][] sendUserCredentials()
	{
		ExcelHelper excelHelper = new ExcelHelper("KTCTC.xlsx", "Aug");
		ArrayList<String> keys = excelHelper.getColumnData(0);
		
		ArrayList<String> val = excelHelper.getColumnData(1);
		String [][] data = new String[keys.size()][2];
		for (int i=0;i<keys.size();i++)
		{
			data[i][0] = keys.get(i);
			data[i][1] = val.get(i);
		}	
		
		String [][] data = {{"Devendra","Fadanvis","amit@patil.com","45","456780","IT"},{"Ajit","Pawar","ajit@pawar.com","56","567890","Finance"}};
		
		return data;
	}
	

	@Test (dataProvider =  "userdata" )
	public void verifyNewUserCanBeAddedWithProvidedData(String firstname, String lastname, String email,String age,String salary,String department)
	{
		
		
	}
}
