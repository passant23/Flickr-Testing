package tests;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassSignUp {
	  AppiumDriver<MobileElement>driver;
	  Locators l = new Locators();
	@BeforeTest
	 public void setUp() throws MalformedURLException {
			DesiredCapabilities	c = new DesiredCapabilities();
//			System.setProperty("webdriver.gecko.driver", "");
			c.setCapability(MobileCapabilityType.DEVICE_NAME,"HUAWEI nova 3i"); 		    
			c.setCapability(MobileCapabilityType.UDID, "GVV7N18730005045");
			c.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			c.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//			c.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
			c.setCapability("unicodeKeyboard", "true");
			c.setCapability("resetKeyboard", "true");
			c.setCapability("appPackage", "com.example.flickr");
			c.setCapability("appActivity", "com.example.flickr.MainActivity");
			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			driver= new  AppiumDriver<MobileElement>(url,c);
			
			
			 driver.findElement(ById.id("Get Started")).click();
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    driver.findElement(By.id(" Sign up here.")).click();
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			
			
			
			
	    }
//	@AfterTest
//	 public void tearDown() {
//			driver.close();
//			driver.quit();
//	        
//	    }
		
}
