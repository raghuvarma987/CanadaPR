package Repo.com;

public class ObjRepo {
	/******************* SIGN IN *********************/
	final static public String EmailAddress="//*[@name='EmailAddress']";
	final static public String Password = "//*[@placeholder='Password']";
	final static public String SignIn   = "//*[text()='SIGN IN']";
	
	/******************** Company Info ***************/
	
	
	final static public String Menu     = "(//*[@class='hasSubmenu'])[1]";
	final static public String CompInfo = "//*[text()='Company Information']";
	final static public String CompName = "//*[@id='CompanyName']";
    final static public String TradeName= "//*[@id='TradeName']";
    public static final String Add1     = "//*[@id='AddressLine1']";
    final static public String Add2     = "//*[@id='AddressLine2']";
    final static public String City     = "(//*[@placeholder='City'])[1]";
    final static public String Province = "(//*[@name='ProvinceId'])";
    final static public String Save     = "//*[@value='Save']";
    
    /*********************** Department ****************/
    
    final static public String AddDpt   = "((//div[@class='sub-nav active'])[1]/child::ul/child::li)[2]";
    final static public String AddNewDp = "//*[@id = 'AdDept']";
    final static public String EnterDpt = "//*[@placeholder='Department Name']";
    final static public String SbmtDpt  = "//*[@id = 'SubmitDepartmentText']";
    
    /************************ EmployeeSetup**************/
	
	

}
