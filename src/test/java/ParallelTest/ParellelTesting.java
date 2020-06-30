package ParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParellelTesting {
	
	WebDriver driver;
	
	@Parameters("myBrowser")
	@BeforeClass
	public void lanuchbrowser(String myBrowser) {
		if(myBrowser.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", 
						"R:\\Testing\\Java\\chromedriver 71\\chromedriver.exe");
			  driver = new ChromeDriver();
		}
		   else if(myBrowser.equalsIgnoreCase("firefox")) {
			   System.setProperty("webdriver.gecko.driver","C:\\Users\\Raghuvarma\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			   driver = new FirefoxDriver();
			   }
		
		
	}
	@Test
	public void checkingparallel() {
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("raghu.chennu44@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Raghu@123");
		driver.findElement(By.xpath("//*[@name='login']")).submit();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Find a Flight: Mercury Tours: ");
	
	}
	@AfterClass
	public void closing() {
		driver.close();
	}
	

}
