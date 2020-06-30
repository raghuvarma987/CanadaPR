package CloudPR.Com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import Repo.com.ObjRepo;
import Utils.UtiltyClass;
import Utils.WebEventListener1;


public class BaseClass {
	
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public static Properties	prop;
	public static EventFiringWebDriver	e_driver;
//	ExlReader excelmethods = new ExlReader("R:\\New Aut\\CloudPR_forCanada\\src\\main\\java\\Com\\TestData\\Login Company Info.xlsx");

	public static WebEventListener1	eventListener;
	
	
	@FindBy(xpath=ObjRepo.EmailAddress)
	public  static WebElement EmailAddress;
	@FindBy(xpath= ObjRepo.Password)
	public static WebElement Password;
	@FindBy(xpath= ObjRepo.SignIn)
	public static WebElement SignIn;
	//@FindBy(xpath=ObjRepo.)
		
	public BaseClass() {
		
		try {
			prop = new Properties();
			
				FileInputStream ip = new FileInputStream("R:\\New Aut\\CloudPR_forCanada\\src\\main\\java\\CloudPR\\Config\\urlpath.properties");
					prop.load(ip);
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				}catch (IOException e) {
				e.printStackTrace();
				}
	       	}
			@BeforeMethod
			public void initialization() throws InterruptedException {
				String browsername = prop.getProperty("browser");
				if(browsername.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", 
							"R:\\Testing\\Java\\chromedriver 71\\chromedriver.exe");
				    driver = new ChromeDriver();
					driver.get("http://www.google.co.in");
				}else {
					System.out.println("ff");
				}
				e_driver = new EventFiringWebDriver(driver);
				//to create obj to event listener handler it register with event firing 
				eventListener = new WebEventListener1();
				e_driver.register(eventListener);
				driver = e_driver;
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(UtiltyClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(UtiltyClass.PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.get(prop.getProperty("URL"));
				Thread.sleep(6000);
				//driver.findElement(By.xpath("//*[@name='EmailAddress']"))
			}
				
			@BeforeTest
			public void setExtent() {
				extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true );
				extent.addSystemInfo("Device Name", "LAPTOP-84BNC9QL");
				extent.addSystemInfo("Device ID", "C10B1634-870A-481A-BE82-553CEF351A16");
				extent.addSystemInfo("Environment", "QA");
				
		}
		
		@AfterTest
		public void endReport(){
			extent.flush();
			extent.close();
		}
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}	
			
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = BaseClass.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit();
		   }
	
			public void signIn() throws InterruptedException {
				EmailAddress.sendKeys("raghu.chennu44@gmail.com");
				Password.sendKeys("Raghu@123");
				Thread.sleep(18000);
				SignIn.click();
			}
			
}




