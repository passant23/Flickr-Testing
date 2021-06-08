package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
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
public class SignUpValid extends BaseClassSignUp {
	

	@SuppressWarnings("deprecation")
	@Test

	public void SignUpValid()
	{
		
	    
	    MobileElement a1= driver.findElement(By.xpath(l.firstName));
		MobileElement a2= driver.findElement(By.xpath(l.lastName));
		String errorAge = l.ageErrorAccessibilityId;
		MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
		MobileElement a4= driver.findElement(By.xpath(l.age));   
		MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
		MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));
	    a1.setValue("test");
		a2.setValue("new");
		a4.setValue("20");
		driver.getKeyboard();
		a5.setValue("newt@test.com");
		a3.setValue("123456789aaA!");
		
	

		  try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		          
		
		a6.click();
		
		
		 driver.findElement(By.id("Tab 3 of 5")).click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    
		  MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"test new\n0 Followers — 0 Following\"]/android.widget.ImageView[1]");
		  assert el1.isDisplayed();
		
		
		
	}
	            
		}

