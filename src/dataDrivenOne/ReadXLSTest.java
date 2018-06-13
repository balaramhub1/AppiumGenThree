package dataDrivenOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadXLSTest {
	
	HSSFSheet sh1;
	
		public void setExcel() throws IOException {
		// TODO Auto-generated method stub
		
		File f1=new File("D:\\FitnessCalTestData.xls");
		  
		  FileInputStream fis = new FileInputStream(f1);
		  
		  // XSSFWorkbook wb =new XSSFWorkbook(fis); - for .xlsx file
		  
		  HSSFWorkbook wb = new HSSFWorkbook(fis);
		  
		  HSSFSheet sh1 = wb.getSheetAt(0);
				  
		  /*int MaxRow=sh1.getLastRowNum();
		  int MaxCol=sh1.getRow(0).getLastCellNum();
		  
		  System.out.println("No of rows with data : "+MaxRow);
		  
		  System.out.println("No of columns in a row is : "+MaxCol);
		  
		  
		 double cellData=sh1.getRow(1).getCell(1).getNumericCellValue();
		  
		  System.out.println("Cell Value at (0,1) is :"+cellData);
		  
		  wb.close();*/
		
	}
	
	public String getData(int rNum,int cNUm)
	{
		int data=(int)sh1.getRow(rNum).getCell(rNum).getNumericCellValue();
		String sData=Integer.toString(data);
		
		return sData;
	}
	
	public int rCount(){
		int Mrow =sh1.getLastRowNum();
			
		return Mrow;		
	}
}
