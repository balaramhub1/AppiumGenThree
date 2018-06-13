package dataDrivenOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DataDrivTwo {
	
	// Test app is Fitness_Calculator.apk
	// Demo for data driven testing using Excel(read excel using apache POI)
	
	AndroidDriver<MobileElement> drv;
	DesiredCapabilities cap;
	HSSFSheet dataSheet;
	int nRow,nCol;	
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException, InterruptedException {
		
		cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A6000");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "com.finessCalculator");
		cap.setCapability("appActivity", "FitnessCalculatorActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		
		drv=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(3000);
		
		  drv.findElement(By.id("com.finessCalculator:id/map")).click();
		  drv.findElement(By.name("One Rep Max")).click();
		
	  }
	
	// Test case method f() depends on data provider "FitnessTestData" or method TestDataOne()...
	
  @Test(dataProvider="FitnessTestData")
  public void f(String wt,String rep) throws InterruptedException, IOException {
	  
	
	  
	  /*String exp="One Rep Max";
	  String act=drv.findElement(By.id("com.finessCalculator:id/actionbar_title")).getAttribute("text");
	  
	  Boolean title=drv.findElement(By.id("com.finessCalculator:id/actionbar_title")).isDisplayed();
	  Assert.assertTrue(title);
	  	  
	  System.out.println("actual string is : "+act);*/
	  
	  //Assert.assertEquals("", ""); 
	  
	  drv.findElement(By.id("com.finessCalculator:id/editText_lnbody_weight")).sendKeys(wt);
	  drv.findElement(By.id("com.finessCalculator:id/editText_rep")).sendKeys(rep);
	  
	  drv.findElement(By.id("com.finessCalculator:id/calculateButton")).click();
	  
	  Thread.sleep(2000);
	  
	  drv.findElement(By.xpath("//android.widget.ImageView[@index='4']")).click();
	  
	  Thread.sleep(2000);
	  
	   
  }
  
  
  @DataProvider(name="FitnessTestData")
  public Object[][] TestDataOne() throws IOException{
	  
	  dataSheet=setUpExl();
	  nRow=dataSheet.getLastRowNum();
	  nCol=dataSheet.getRow(0).getLastCellNum();
	  Object[][] data=new Object[nRow][nCol];
	  int count=0;
	  for(int i=1;i<nRow+1;i++){
		  for(int j=0;j<nCol;j++){
			  int cellData=(int) dataSheet.getRow(i).getCell(j).getNumericCellValue();
			  String strdata=Integer.toString(cellData);
			  data[count][j]=strdata;
		  }
		  count++;
		  
	  }
	return data;
	  	  
  }
  
  public HSSFSheet setUpExl() throws IOException{
	  
	  File f1=new File("\\FitnessTestData.xls");
	  FileInputStream fis = new FileInputStream(f1);
	  // XSSFWorkbook wb =new XSSFWorkbook(fis); - for .xlsx file
	  HSSFWorkbook wb = new HSSFWorkbook(fis);
	  HSSFSheet sh1 = wb.getSheetAt(0);
	  
	  return sh1;
  }
  
  
  
  @AfterClass
  public void afterClass() {
	  drv.quit();
  }

}
