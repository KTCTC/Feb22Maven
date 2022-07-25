package brockenlink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinkClass2 {
	
	@Test
	public void sampleTestCase()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://www.facebook.com/");	
		String baseURL = "https://www.facebook.com";
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for (WebElement each:links)
		{
			String lnk = each.getAttribute("href");
			if (lnk.contains("http"))
			{
				System.out.println(lnk);
			}
			else
			{
				String actualUrl = baseURL+lnk;
				System.out.println(actualUrl);
			}
			
		}
		
	}

}
