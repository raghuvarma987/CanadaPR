package Cloud_PR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CloudPR.Com.Base.BaseClass;

public class EmployeeSetupObjRepo extends BaseClass{
	
	@FindBy(xpath="//*[@id='lnkEmployees']")
	public WebElement empSetup;
	@FindBy(xpath="//*[@id='hrefCreate']")
	public WebElement createemp;
	@FindBy(xpath="//*[@placeholder='First Name']")
	public WebElement fname;
	@FindBy(xpath="//*[@placeholder='Last Name']")
	public WebElement lname;
	@FindBy(xpath="//*[@placeholder='Street']")
	public WebElement street;
	@FindBy(xpath="//*[@placeholder='City']")
	public WebElement city;
	@FindBy(xpath="//*[@name='Province']")
	public WebElement province;
	@FindBy(xpath="//*[@placeholder='SIN']")
	public WebElement sin;
	@FindBy(xpath="//*[@name='BirthDate']")
	public WebElement dob;
	@FindBy(xpath="//*[@name='PostalCode']")
	public WebElement pincode;
	@FindBy(xpath="//*[@id='SubmitPersonalInfo']")
	public WebElement submite;
	@FindBy(xpath="(//*[text()='Wages'])[1]")
	public WebElement wages;
	@FindBy(xpath="(//*[@placeholder='0.00 (Enter Amount)'])[1]")
	public WebElement salary;
	@FindBy(xpath="//*[@id='PayFrequency']")
	public WebElement payfrequency;
	@FindBy(xpath="//*[@name='WagesInformation.HireDate']")
	public WebElement hiredate;
	@FindBy(xpath="(//*[text()='Taxes'])[1]")
	public WebElement taxes;
	@FindBy(xpath="(//*[@name='TaxInformation.Province'])[1]")
	public WebElement provice;
	@FindBy(xpath="//*[@id='employeeUpdate']")
	public WebElement updatebtn;
	@CacheLookup
	@FindBy(xpath="//*[@name='TaxInformation.Province']")
	public WebElement province1;
	
	public void createNewEmployee(String FirstName, String LastName, String Street, String City, String Province,String Sin, String DOB, String PCode, String Salary, String PPeriod, String HireDate, String Province1 ) throws InterruptedException {
		empSetup.click();
		createemp.click();
		fname.clear();
		fname.sendKeys(FirstName);
		lname.clear();
		lname.sendKeys(LastName);
		street.clear();
		street.sendKeys(Street);
		city.clear();
		city.sendKeys(City);
		Select se = new Select(province);
		se.selectByVisibleText(Province);
		sin.sendKeys(Sin);
		dob.sendKeys(DOB);
		pincode.sendKeys(PCode);
		submite.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(wages));
		//wait.until(ExpectedConditions.
		//wages.click();
		/*wait.until(ExpectedConditions.)
		element.click();*/
		salary.sendKeys(Salary);
		Select se2 = new Select(payfrequency);
		se2.selectByVisibleText(PPeriod);
		Thread.sleep(6000);
		hiredate.sendKeys(HireDate);
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(taxes));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		element1.click();
		Thread.sleep(11000);
		//provice.sendKeys(Province1);
		Select se1 = new Select(province1);
		se1.selectByVisibleText(Province1);
		Thread.sleep(11000);
		updatebtn.click();
		Thread.sleep(5000);

		
	}
	
	
	
	

}
