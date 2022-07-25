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

public class BrockenLinkClass4ToolQA2 {

	@Test
	public void sampleTestCase() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://demoqa.com/links");
		String baseURL = "https://demoqa.com/";
		List<WebElement> links = driver.findElements(By.tagName("a"));

		String actualUrl = "";
		for (WebElement each : links) {
			String lnk = each.getAttribute("href");
			if (lnk != null) {
				if (lnk.contains("http")) {
					actualUrl = lnk;
					System.out.println(actualUrl);
				} else {
					actualUrl = baseURL + each.getAttribute("id");
					System.out.println(actualUrl);
				}
			}
printStatusCodeAndMessageOfLink(actualUrl);
		}

	}
	
	public void printStatusCodeAndMessageOfLink(String link) 
	{
		try {
			URL url = new URL(link);
			URLConnection urlConn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection)urlConn;
			
			http.setConnectTimeout(15000);
			
			http.connect();
			
			int resCode = http.getResponseCode();
			
			String resMsg = http.getResponseMessage();
			if (resCode>=400)
			{
				System.out.println(link);
				System.out.println("is brocken with status code = "+resCode+" and response message = "+resMsg);
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
