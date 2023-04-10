package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excelsheet implements Constants
{
  public static String getdata(String excelsheetpath, String sheetname, int rownumber, int cellnumber ) {
	  String v = "";
	  try {
		  FileInputStream fis = new FileInputStream(excelsheetpath);
	     Workbook wb = WorkbookFactory.create(fis);	 
	     v = wb.getSheet(sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
	  }
	  catch(Exception ex) {
		  ex.printStackTrace();
		  Reporter.log("Unable to fetch the data from excel sheet.", true);
	  }
	  return v;
  }
}
