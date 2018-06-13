package dataDriveTwo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestOne {
	
	// Test app is Fitness_Calculator.apk
	// Demo for data driven testing using Data Provider annotation
	
	AndroidDriver<MobileElement> drv;
	DesiredCapabilities cap;
	
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException, InterruptedException {
		
		cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
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
  public void f(String wt,String rep) throws InterruptedException {
	  
	  
	  
	  	 	  
	  drv.findElement(By.id("com.finessCalculator:id/editText_lnbody_weight")).sendKeys(wt);
	  drv.findElement(By.id("com.finessCalculator:id/editText_rep")).sendKeys(rep);
	  
	  drv.findElement(By.id("com.finessCalculator:id/calculateButton")).click();
	  	  
	  Thread.sleep(2000);
	  
	  drv.findElement(By.xpath("//android.widget.ImageView[@index='4']")).click();
	  
	  Thread.sleep(2000);
	  
  }
  
  @DataProvider(name="FitnessTestData")
  public String[] TestData() throws IOException{
	  ReadTxtOne rTO1=new ReadTxtOne();
	  
	  String [] data=new String[2];
	  data[0]=rTO1.testData1[0];
	  data[1]=rTO1.testData1[1];
	  return data;
  }
  
 
  @AfterClass
  public void afterClass() {
	  drv.quit();
  }

}
