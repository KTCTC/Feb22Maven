package brockenlink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinkClass3ToolQA {
	
	@Test
	public void sampleTestCase()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://demoqa.com/links");	
		String baseURL = "https://demoqa.com/";
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		String actualUrl = "";
		for (WebElement each:links)
		{
			String lnk = each.getAttribute("href");
			if (lnk!=null && lnk.contains("http"))
			{
				actualUrl = lnk;
				System.out.println(actualUrl);
			}
			else
			{
				 actualUrl = baseURL+ each.getAttribute("id");
				System.out.println(actualUrl);
			}
			
		}
		
	}

}
