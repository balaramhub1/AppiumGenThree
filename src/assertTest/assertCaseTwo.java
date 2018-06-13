package assertTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class assertCaseTwo {
	
	// Test app is Fitness_Calculator.apk
	// Demonstration for Assertion - True(pass case )
	
	AndroidDriver<MobileElement> drv;
	DesiredCapabilities cap;
	
	
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
		
	  }
	
	// Test case method f() depends on data provider "FitnessTestData" or method TestDataOne()...
	
  @Test
  public void f() throws InterruptedException {
	  
	  drv.findElement(By.id("com.finessCalculator:id/map")).click();
	  drv.findElement(By.name("One Rep Max")).click();
	  
	  String exp="One Rep Max";
	  String act=drv.findElement(By.id("com.finessCalculator:id/actionbar_title")).getAttribute("text");
	  
	  Boolean title=drv.findElement(By.id("com.finessCalculator:id/actionbar_title")).isDisplayed();
	  Assert.assertTrue(title);
	    	  
	  System.out.println("actual string is : "+act);
	  
	  Assert.assertEquals(act, exp);
	  
	  System.out.println("Actual and Expected Matched...");
	  
	  drv.findElement(By.id("com.finessCalculator:id/editText_lnbody_weight")).sendKeys("5");
	  drv.findElement(By.id("com.finessCalculator:id/editText_rep")).sendKeys("8");
	  
	  drv.findElement(By.id("com.finessCalculator:id/calculateButton")).click();
	  
	  Thread.sleep(2000);
	  
	  drv.findElement(By.xpath("//android.widget.ImageView[@index='4']")).click();
	  
	  Thread.sleep(2000);
	  
  }
  
    @AfterClass
  public void afterClass() {
	  drv.quit();
  }

}
