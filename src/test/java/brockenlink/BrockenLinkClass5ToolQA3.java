package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrockenLinkClass5ToolQA3 {

	@Test
	public void verifyLinksAreBrockenOrNot() {
		SoftAssert sAssert = new SoftAssert();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://demoqa.com/links");
		String baseURL = "https://demoqa.com/";
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		String actualUrl = null;
		for (WebElement each : links) {
			String lnk = each.getAttribute("href");
			if (lnk != null) {
				if (lnk.contains("http")) {
					actualUrl = lnk;
					
				} else {
					actualUrl = baseURL + each.getAttribute("id");
					
				}
				int code = printStatusCodeAndMessageOfLink(actualUrl);
				  if (code>=400)
				  {
					  sAssert.assertTrue(false, actualUrl+ " is brcken with status code = "+code);
				  }
				  else
				  {
					  sAssert.assertTrue(true);
				  }
			}


		}
		sAssert.assertAll();

	}
	
	public int printStatusCodeAndMessageOfLink(String link) 
	{
		int resCode = 0;
		try {
			URL url = new URL(link);
			URLConnection urlConn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection)urlConn;			
			http.setConnectTimeout(15000);
			
			http.connect();
			
			 resCode = http.getResponseCode();			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resCode;
	}

}
