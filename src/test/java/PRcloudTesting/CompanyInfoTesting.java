package PRcloudTesting;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CloudPR.Com.Base.BaseClass;
import Cloud_PR_Pages.CompanyRepo;
import Utils.UtiltyClass;

public class CompanyInfoTesting extends BaseClass{
	public String sheetname = "CompInfo";

	@Test(dataProvider="settocomp1", groups = { "Smoke" })
	
	public void setcmp(String companyname, String tradename, String address1, String address2, String City, String Province) {
		
		CompanyRepo cmprepo = PageFactory.initElements(driver, CompanyRepo.class);
		
		cmprepo.settingcompany(companyname, tradename, address1, address2, City, Province);
	}
	
	@DataProvider(name ="settocomp1")
	public Object[][] settocomp(){
		Object[][] data = UtiltyClass.getData(sheetname);
		return data;
	}
}
