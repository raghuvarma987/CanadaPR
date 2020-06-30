package PRcloudTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import CloudPR.Com.Base.BaseClass;
import Cloud_PR_Pages.DpartmentRepositary;

public class DepartmentTest extends BaseClass{
	public String sheetName = "";
	
	@SuppressWarnings("unused")
	
	@Test
	public void departmentPageTitleTest() throws InterruptedException {
		
		DpartmentRepositary dptrepo = PageFactory.initElements(driver,DpartmentRepositary.class);
		extentTest = extent.startTest("departmentPageTitleTest");
		dptrepo.signIn();
		dptrepo.createDpt("Testing");
		String testing = driver.findElement(By.xpath("((//div[@class='awe-tablw'])[2]//table/tbody/tr)[3]")).getText();
		System.out.println(testing);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Checkmark Canada Cloud Payroll | Departments");
		
	}
	
	

}
