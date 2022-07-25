package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindStatusCodeOfLink {
	
	@Test
	public void sampleTestCase() throws IOException
	{
String link = "https://demoqa.com/bad-request";
		
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)urlConn;
		
		http.setConnectTimeout(15000);
		
		http.connect();
		
		int resCode = http.getResponseCode();
		
		String resMsg = http.getResponseMessage();
		System.out.println(resCode);
		System.out.println(resMsg);
	}

}
