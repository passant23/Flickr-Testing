package appiumtests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class appium {
	static AppiumDriver <MobileElement>driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			openFlickr();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.getStackTrace();
		}
	}
	public static void openFlickr() throws Exception {
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName","HUAWEI nova 3i"); 		    
		c.setCapability("udid", "GVV7N18730005045");
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "9");
		c.setCapability("appPackage", "com.example.flickr");
		c.setCapability("appActivity", "com.example.flickr.MainActivity");
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		driver= new AppiumDriver<MobileElement>(url,c);
		System.out.println("Application started...");
		MobileElement next = driver.findElementByXPath("");
		next.click();
	}

}
