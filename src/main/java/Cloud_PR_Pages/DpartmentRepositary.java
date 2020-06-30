package Cloud_PR_Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import CloudPR.Com.Base.BaseClass;
import Repo.com.ObjRepo;

public class DpartmentRepositary extends BaseClass{
	@FindBy(xpath=ObjRepo.Menu)
	public WebElement Menu;
	@FindBy(xpath=ObjRepo.AddDpt)
	public WebElement AddDpt;
	@FindBy(xpath=ObjRepo.AddNewDp)
	public WebElement AddNewDp;
	@FindBy(xpath=ObjRepo.EnterDpt)
	public WebElement EnterDpt;
	@FindBy(xpath=ObjRepo.SbmtDpt)
	public WebElement SbmtDpt;
	
	public void createDpt(String dptame) {
		Menu.click();
		AddDpt.click();
		AddNewDp.click();
		EnterDpt.sendKeys(dptame);
		SbmtDpt.click();
	}
}
