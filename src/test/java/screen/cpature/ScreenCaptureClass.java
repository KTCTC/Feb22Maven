package screen.cpature;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenCaptureClass {
	
	@Test
	public void sampleTestCase() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://demoqa.com/webtables");
				
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File f = ts.getScreenshotAs(OutputType.FILE);
		
		File out = new File(System.getProperty("user.dir")+"\\abc.png");
		
		FileUtils.copyFile(f, out);
	}

}
