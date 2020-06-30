package PRcloudTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CloudPR.Com.Base.BaseClass;
import Cloud_PR_Pages.EmployeeSetupObjRepo;
import Utils.UtiltyClass;

public class EmployeeSetupTest extends BaseClass{
	
	public String sheetname = "EmployeeData";
	EmployeeSetupObjRepo emprepo = new EmployeeSetupObjRepo();
	
	@Test(enabled = false,dataProvider="settoemp")
	public void validatingEmployee(String FirstName, String LastName, String Street, String City, String Province, String Sin, String DOB, String PCode, String Salary, String PPeriod, String HireDate, String Province1 ) throws InterruptedException {
		EmployeeSetupObjRepo emprepo = PageFactory.initElements(driver, EmployeeSetupObjRepo.class);
		emprepo.createNewEmployee(FirstName, LastName, Street, City, Province, Sin, DOB, PCode, Salary, PPeriod, HireDate, Province1);
	}
	@DataProvider(name="settoemp")
	public Object[][] settoemp(){
		Object[][] data = UtiltyClass.getData(sheetname);
		return data;
	}
	@Test(dataProvider="settoemp", groups = { "Smoke" })
	public void gettingdatfromwebpage() {// for test
		
		EmployeeSetupObjRepo emprepo = PageFactory.initElements(driver, EmployeeSetupObjRepo.class);
		 emprepo.empSetup.click();
		 emprepo.createemp.click();
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement ddd = driver.findElement(By.xpath("//*[@id='datepicker2']"));
		 WebDriverWait wait1 = new WebDriverWait(driver, 50);
		 wait1.until(ExpectedConditions.visibilityOf(ddd)).click();
		 WebElement e = driver.findElement(By.xpath("//*[@class='datepicker-days']//tr[4]/td[5]"));
		 String date = e.getText();
		 System.out.println(date);
		 //*[@class='form-control'])[6]

		 }

}
