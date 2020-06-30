package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import CloudPR.Com.Base.BaseClass;



public class UtiltyClass extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long PAGE_IMPLICIT_WAIT = 20;
	
	public static String TEST_DATA__SHEET_PATH = "R:\\New Aut\\CloudPR_forCanada\\src\\main\\java\\Com\\TestData\\Login Company Info.xlsx";
	
	static Workbook workbook;
	static Sheet sheet;	
	public static Object[][] getData(String sheetname) {		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA__SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook =  WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum() ; i++) {
			for(int k=0; k< sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	

	//==========================FOR TAKING SCREENSHOT============================================
	
	public static void getScreenshot() throws IOException{
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currdir = System.getProperty("user.dir");
		FileUtils.copyFile(scr, new File(currdir+ "/screenshots/" + System.currentTimeMillis()+ ".png"));
		System.out.println("Screenshot has been taken");
	}
	//==============================TO WRITE DATA ON EXCEL==========================================
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
		 
		 
		 
		 
		
	}
