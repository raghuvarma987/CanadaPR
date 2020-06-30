package Cloud_PR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CloudPR.Com.Base.BaseClass;
import Repo.com.ObjRepo;

public class CompanyRepo extends BaseClass{
		
	@FindBy(xpath= ObjRepo.Menu)
	public WebElement	compset;
	@FindBy(xpath= ObjRepo.CompInfo)
	public WebElement	compinfo;
	@FindBy(xpath= ObjRepo.CompName)
	public WebElement	compname;
	@FindBy(xpath= ObjRepo.TradeName)
	public WebElement	tradname;
	@FindBy(xpath= ObjRepo.Add1)
	public WebElement	add1;
	@FindBy(xpath= ObjRepo.Add2)
	public WebElement	add2;
	@FindBy(xpath= ObjRepo.City)
	public WebElement	city;
	
	@FindBy(xpath= ObjRepo.Province)
	public WebElement	province;
	@FindBy(xpath= ObjRepo.Save)
	public WebElement	save;
	
	public void settingcompany(String companyname, String tradename, String address1, String address2, String City, String Province) {
		compset.click();       
		compinfo.click();
		compname.clear();
		compname.sendKeys(companyname);
		tradname.clear();
		tradname.sendKeys(tradename);
		add1.clear();
		add1.sendKeys(address1);
		add2.clear();
		add2.sendKeys(address2);
		city.clear();
		city.sendKeys(City);
		Select se = new Select(province);
		se.selectByVisibleText(Province);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(save)).click();
		//wait.until(ExpectedConditions.
	
		
	}
     
	
	
	
	
	
	
	
	
	

}
