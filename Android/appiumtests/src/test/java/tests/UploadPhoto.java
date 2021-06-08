package tests;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;


////Numbers & special characters////



public class UploadPhoto extends BaseClassUpload {
	
	@Test
	public void FailedUpload(){
		
	
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElementById("Camera Roll\nTab 3 of 6").click();
		
		boolean upload;
		  try {
    	    driver.findElement(By.id("Upload now"));
    	    upload = true;
			System.out.println("Upload");
    	 } catch (NoSuchElementException e) {
    	    upload = false;
			System.out.println("upload Failed");
    	 }
		 assertEquals(upload, true);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//uploading
		MobileElement el1 = driver.findElementByAccessibilityId("Upload now");
		el1.click();
		
		MobileElement el2 = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		el2.click();

		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("About\nTab 1 of 6");
		el7.click();


		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		boolean uploaded;
//		  try {
//			  uploaded	=driver.findElementByAccessibilityId("1 Photos").isDisplayed();
//
//			System.out.println("Uploaded");
//    	 } catch (NoSuchElementException e) {
//    	    uploaded = false;
//			System.out.println("upload Failed check 2");
//    	 }
//		  assertEquals(uploaded, true);
		  assert driver.findElementByAccessibilityId("1 Photos").isDisplayed();
		
		 
		 driver.findElementById("Publics\nTab 4 of 6").click();
		 
			
			boolean existsInPublics;
			  try {
	    	    driver.findElement(By.id("dummy"));
	    	    existsInPublics = true;
				System.out.println("Uploaded");
	    	 } catch (NoSuchElementException e) {
	    		 existsInPublics = false;
				System.out.println("exists in publics");
	    	 }
			 assertEquals(existsInPublics, true);
		 
		 
		
		
	}
}