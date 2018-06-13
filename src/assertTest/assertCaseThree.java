package assertTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class assertCaseThree {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A6000");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "com.finessCalculator");
		cap.setCapability("appActivity", "FitnessCalculatorActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		
		drv=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
	  
  }
  
  
  @Test
  public void f() {
	  
	 // Verify.verify(expression);
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  drv.quit();
  }

}
