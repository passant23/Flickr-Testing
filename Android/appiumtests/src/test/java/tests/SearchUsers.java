	package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.testng.annotations.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
	import java.util.logging.Level;

	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.touch.offset.PointOption;

public class SearchUsers extends BaseClass {
	
	@Test
	public void UnvalidSearch(){

	
	
	String User="p test";
	driver.findElementById("Tab 2 of 5").click();
	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
	el7.sendKeys(User);
	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	driver.findElementById("People\nTab 2 of 3").click();
	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 boolean present;
		 
//    	try {
//    	    driver.findElement(By.id(User));
//    	    present = true;
//			System.out.println("found the user");
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//			System.out.println("this user isn't found although it exists");
//    	 }
//		
//    	 assertEquals(present, true);
		 assert  driver.findElement(By.id(User)).isDisplayed() : "this user isn't found although it exists";

	}


}
