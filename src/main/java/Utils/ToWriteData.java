package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToWriteData {
		//public static String filename = System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xlsx\\Suite.xlsx";
		public  String path;
		public  FileInputStream fis = null;
		public  FileOutputStream fileOut =null;
		private XSSFWorkbook workbook = null;
		private XSSFSheet sheet = null;
		private XSSFRow row   =null;
		private XSSFCell cell = null;
		
		
	public ToWriteData(String path) {
			
			this.path=path;
			try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}	
			// returns the row count in a sheet

			public int getRowCount(String sheetName){
				int index = workbook.getSheetIndex(sheetName);
				if(index==-1)
					return 0;
				else{
				sheet = workbook.getSheetAt(index);
				int number=sheet.getLastRowNum()+1;
				return number;
				}
				
			}
			// returns the data from a cell
			
			public boolean setCellData(String sheetName,String colName,int rowNum, String data){
				try{
				fis = new FileInputStream(path); 
				workbook = new XSSFWorkbook(fis);

				if(rowNum<=0)
					return false;
				
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
				
				
				sheet = workbook.getSheetAt(index);
				

				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;

				sheet.autoSizeColumn(colNum); 
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);
				
				cell = row.getCell(colNum);	
				if (cell == null)
			        cell = row.createCell(colNum);

			    // cell style
			    //CellStyle cs = workbook.createCellStyle();
			    //cs.setWrapText(true);
			    //cell.setCellStyle(cs);
			    cell.setCellValue(data);

			    fileOut = new FileOutputStream(path);

				workbook.write(fileOut);

			    fileOut.close();	

				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean addColumn(String sheetName,String colName){
				//System.out.println("**************addColumn*********************");
				
				try{				
					fis = new FileInputStream(path); 
					workbook = new XSSFWorkbook(fis);
					int index = workbook.getSheetIndex(sheetName);
					if(index==-1)
						return false;
					
				XSSFCellStyle style = workbook.createCellStyle();
				style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				
				sheet=workbook.getSheetAt(index);
				
				row = sheet.getRow(0);
				if (row == null)
					row = sheet.createRow(0);
				
				//cell = row.getCell();	
				//if (cell == null)
				//System.out.println(row.getLastCellNum());
				if(row.getLastCellNum() == -1)
					cell = row.createCell(0);
				else
					cell = row.createCell(row.getLastCellNum());
			        
			        cell.setCellValue(colName);
			        cell.setCellStyle(style);
			        
			        fileOut = new FileOutputStream(path);
					workbook.write(fileOut);
				    fileOut.close();		    

				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
				
				return true;
				
				
			}

}
