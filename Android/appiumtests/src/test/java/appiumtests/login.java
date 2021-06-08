package appiumtests;
import java.net.MalformedURLException;
import java.net.URL;
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

public class login {
    private static String reportDirectory = "reports";
    private static String reportFormat = "xml";
    private static String testName = "login";
    protected static AndroidDriver<AndroidElement> driver ;

    static DesiredCapabilities c ;
    public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		setUp();
		try{
			testlogin();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.getStackTrace();
		}
	}
   
   
    public static void setUp() throws MalformedURLException {
    	c = new DesiredCapabilities();
		c.setCapability("deviceName","HUAWEI nova 3i"); 		    
		c.setCapability("udid", "GVV7N18730005045");
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "9");
		c.setCapability("appPackage", "com.flickr.android");
		c.setCapability("appActivity", "com.yahoo.mobile.client.android.flickr.ui.misc.LoginActivity");
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		driver= new  AndroidDriver<AndroidElement>(url,c);
    }

   
    public static void testlogin() {
    	 driver.findElement(By.id("activity_welcome_sign_button")).click();
    	 
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
         driver.findElement(By.id("login-email")).click();
         driver.findElement(By.id("login-email")).click();
    	  driver.findElement(By.id("login-email")).clear();
    	  driver.findElement(By.id("login-email")).sendKeys("passantahmedmaher@gmail.com");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
         driver.findElement(By.xpath("//*[@text='Next']")).click();
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
         driver.findElement(By.id("login-password")).clear();
         driver.findElement(By.id("login-password")).sendKeys("1234567891011!!");
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign in']")));
         driver.findElement(By.xpath("//*[@text='Sign in']")).click();

    }

   
    public void tearDown() {
        driver.quit();
    }
	
}