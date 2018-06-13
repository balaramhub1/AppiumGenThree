package waitCommand;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class implWaitOne {
	
	AndroidDriver drv;
	DesiredCapabilities cap;
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Lenovo A6000");
		cap.setCapability("appPackage", "net.one97.paytm");
		cap.setCapability("appActivity", "landingpage.activity.AJRMainActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
		
		drv=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
  }
  
  @Test
  public void f() {
	  
	  System.out.println("Paytm Successfully launched");
	  drv.findElement(By.name("Electricity")).click();
	  
	  drv.findElement(By.id("net.one97.paytm:id/select_opertor_layout")).click();
	  drv.findElementByAndroidUIAutomator("new UiSelector().text(\"BSES Yamuna - Delhi\")").click();
	  
	  
	  WebDriverWait wait=new WebDriverWait(drv,5);
	  //wait.until(ExpectedConditions.elementToBeClickable(element));
	  // can do with music player for pause/play button
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
