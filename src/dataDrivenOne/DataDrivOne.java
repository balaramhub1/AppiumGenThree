package dataDrivenOne;

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

public class DataDrivOne {
	
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
  public Object[][] TestDataOne(){
	  Object[][] data=new Object[4][2];
	  
	  data[0][0]="5";
	  data[0][1]="8";
	  
	  data[1][0]="10";
	  data[1][1]="7";
	  
	  data[2][0]="15";
	  data[2][1]="6";
	  
	  data[3][0]="6";
	  data[3][1]="9";
	  
	  return data;
	  
  }
  

  @AfterClass
  public void afterClass() {
	  drv.quit();
  }

}
