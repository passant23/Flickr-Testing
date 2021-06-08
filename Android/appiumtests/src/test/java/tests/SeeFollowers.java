package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
public class  SeeFollowers extends BaseClass{
	@Test
	public void SeeFollowers(){

		 //back to check in my followers list
				
		 
		 try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	boolean correct = false ;
	
		  try {
    	    driver.findElement(By.id("maria o\n0 Followers — 0 Following")).click();
    	    correct = true;
			System.out.println("maria o\n0 Followers — 0 Following");
    	 } catch (NoSuchElementException e) {
    		 correct = false ;
			System.out.println("Viewing followers list failed");
    	 }
		 assertEquals(correct, true);
		 assert driver.findElementById("Followers").isDisplayed();

	}


}
