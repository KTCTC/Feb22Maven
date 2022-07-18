package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demoqa.com/text-box");
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id("uploadfile_0"))).perform();

		

		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\febprop.properties");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot rt = new Robot();
        Thread.sleep(3000);
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);

		rt.keyRelease(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);


		rt.keyPress(KeyEvent.VK_ENTER);

		rt.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("submitbutton")).click();

		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[@id='res']/center")));

		String msg = driver.findElement(By.xpath("//h3[@id='res']/center")).getText();

		if (msg.equals("1 file\nhas been successfully uploaded.")) {
			System.out.println("Test case is passed");
		} else {
			System.out.println("Test case is failed");
		}

	}

}
