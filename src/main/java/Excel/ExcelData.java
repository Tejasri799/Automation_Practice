package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static String[][] data;			//initializing an array to store the data

	public static String filename = "src\\test\\resources\\Testdata\\regi.xlsx";  //path for excel file location
	   public static void getExcel(String sheet1 ){
	  data= new String[5][10];   //declaring array size
	    File f= new File(filename);			//object creation for excel file
	    for(int Row=0;Row<=4;Row++){
	  try {
	FileInputStream fis= new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet(sheet1);
	XSSFRow row=sheet.getRow(Row);
	for(int column=0;column<=9;column++){
	XSSFCell cell=row.getCell(column);
	data[Row][column]=cell.getStringCellValue();    //function to read the data from excel
	}
	   } catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	  catch (IOException e)
	  		{
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
			}
	    }
   }
}
	