package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
public class ForgotPassword extends BaseClassLogIn {

	
	
	@SuppressWarnings("deprecation")
	@Test
	public void ForgetPassword() {
		
	    
	    MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
	    e1.click();
	    e1.sendKeys("pa@gmailgmail.com");
	   
	   
	   try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
	    
	    driver.findElementById(l.nextId).click();
	    
	    
	    
	    
	    MobileElement el1 = driver.findElementById("Forgot password?");
		el1.click();
		
		
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		MobileElement el2 = driver.findElementById("Send email");
		
		MobileElement el4 = driver.findElementById("Can't access your email?");
		MobileElement el5 = driver.findElementById("Change your Flickr password");
		
		
		assert el5.isDisplayed();
		
		assert el4.isDisplayed();
		
		assert el2.isDisplayed();
		
		el2.click();
		
		MobileElement el3 = driver.findElementById("Invalid email or password");
		assert !(el3.isDisplayed()) : "Unexpected behaviour after clicking send email with an exisiting account";
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
