package tests;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

////charachters////

public class AboutFirstFourFields extends BaseClass {
	
	@Test
	public void valid_About_Description(){
		
		String fieldPartialName="Description\n";
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
	
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MobileElement el7 = driver.findElementById("Description\nAdd Description...");
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="Description changed";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys("Description changed");
		driver.findElementById("Done").click();
		MobileElement el11 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
		el11.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 boolean present;
		 
//    	 try {
//    	    driver.findElement(By.id(fieldPartialName+newPart));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
//    	 assertEquals(present, true);
		 assert  driver.findElement(By.id(fieldPartialName+newPart)).isDisplayed();
		 ////////Hometwon////////
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String fieldPartialName2="Hometown\n";
		 el7 =  driver.findElementById("Hometown\nAdd Hometown...");
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart2="Hometown $$$@222";
		el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart2);
		driver.findElementById("Done").click();
		el11 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
		el11.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		 boolean present;
		 
//    	 try {
//    	    driver.findElement(By.id(fieldPartialName+newPart));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
//    	 assertEquals(present, true);
		 assert  driver.findElement(By.id(fieldPartialName2+newPart2)).isDisplayed();
		 
		 //////////Occupation////////////
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 String fieldPartialName3="Occupation\n";
		 el7 =  driver.findElementByAccessibilityId("Occupation\nAdd Occupation...");
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		 String newPart3="%%%% changed";
		 el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart3);
		driver.findElementById("Done").click();
		 el11 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
		el11.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 assert  driver.findElement(By.id(fieldPartialName3+newPart3)).isDisplayed();
		/////////////Current city//////////////////
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String fieldPartialName4="Current city\n";

		

		 
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Current city\nAdd Current City...\nVisible to: Any Flickr member");
		el1.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		 String newPart4="Current city changed";
		 el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys("Current city changed");
		driver.findElementById("Done").click();
		 el11 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
		el11.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String extraPart="\nVisible to: Any Flickr member";
		
		
		 
		 
		
		 driver.findElement(By.id("Tab 4 of 5")).click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			
		 driver.findElement(By.id("Tab 3 of 5")).click();
		 
		    assert  driver.findElement(By.id(fieldPartialName+newPart)).isDisplayed();
		    assert  driver.findElement(By.id(fieldPartialName2+newPart2)).isDisplayed();
		    assert  driver.findElement(By.id(fieldPartialName3+newPart3)).isDisplayed();
		    assert  driver.findElement(By.id(fieldPartialName4+newPart4+extraPart)).isDisplayed();
			
	 
	}
}
	
	