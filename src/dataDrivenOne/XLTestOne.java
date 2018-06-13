package dataDrivenOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XLTestOne {
	
	public static File f1;
	public static FileInputStream fis;
	public static HSSFWorkbook wb;
	public static HSSFSheet sh1;
	public static int MaxRow;
	public static int MaxCol;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f1=new File("\\FitnessTestData.xls");
		  
		  FileInputStream fis = new FileInputStream(f1);
		  
		  // XSSFWorkbook wb =new XSSFWorkbook(fis); - for .xlsx file
		  
		  HSSFWorkbook wb = new HSSFWorkbook(fis);
		  
		  HSSFSheet sh1 = wb.getSheetAt(0);
		  
		  MaxRow=sh1.getLastRowNum();
		  MaxCol=sh1.getRow(0).getLastCellNum();
		  
		  System.out.println("No of rows with data : "+MaxRow);
		  System.out.println("No of columns in a row is : "+MaxCol);
		  
		  for(int i=1;i<MaxRow+1;i++){
			  for(int j=0;j<MaxCol;j++){
				  
				  int cellData=(int)sh1.getRow(i).getCell(j).getNumericCellValue();
				  //String sData=Integer.toString(cellData);
				  System.out.println("Cell Value at ("+i+","+j+") is :"+cellData);
				  
			  }
		  }
		  
		  wb.close();

	}

}
