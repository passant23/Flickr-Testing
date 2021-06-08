package tests;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class FollowUnfollow extends BaseClass{

	
	@Test(priority=1)
	public void InvalidFollow(){

	String User="p aa";
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
		 
//    	 try {
//    	    driver.findElement(By.id(User));
//    	    present = true;
//			System.out.println("found the user");
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//			System.out.println("this user isn't found although it exists");
//    	 }
		
		 assert  driver.findElement(By.id(User)).isDisplayed() : "this user isn't found although it exists";
		 
		 driver.findElementById(User).click();
		 try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
    	 try {
    	    driver.findElement(By.id("Follow"));
    	    present = true;
			System.out.println("Followed sucessfuly");
    	 } catch (NoSuchElementException e) {
    	    present = false;
			System.out.println("Follow failed");
    	 }
		 
    	 assert  driver.findElement(By.id("Follow")).isDisplayed();
		 
		 //back to check in my followers list
		 
		 driver.findElementById("Tab 3 of 5").click();
		  try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 boolean followed;
//		  try {
//    	    driver.findElement(By.id("maria ossama\n0 Followers — 1 Following"));
//    	    followed = true;
//			System.out.println("maria ossama\n0 Followers — 1 Following");
//    	 } catch (NoSuchElementException e) {
//    	    followed = false;
//			System.out.println("Follow failed");
//    	 }
		  assert  driver.findElement(By.id("maria ossama\\n0 Followers � 1 Following")).isDisplayed();
		 
		 driver.close();
		 driver.quit();
		 

	}
	@Test(priority=2)
	public void UnvalidUnfollow(){
	
	

	
	
	String User="p aa";
	driver.findElementById("Tab 2 of 5").click();

	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
	el7.clear();
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
		
		 boolean present=false;
		 
//    	 try {
//    	    driver.findElement(By.id(User));
//    	    present = true;
//			System.out.println("found the user");
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//			System.out.println("this user isn't found although it exists");
//    	 }
		
    	 
    	 
    	 assert driver.findElement(By.id(User)).isDisplayed() :"this user isn't found although it exists";
    	 
//    	 assertEquals(present, true);
		 
		 
		 driver.findElementById(User).click();
		 try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
    	 try {
    	    driver.findElement(By.id("Unfollow"));
    	    present = true;
			System.out.println("unFollowed sucessfuly");
    	 } catch (NoSuchElementException e) {
    	    present = false;
			System.out.println("unFollow failed");
    	 }
		 
    	 assertEquals(present, true);
		 
		 //back to check in my followers list
		 
		 driver.findElementById("Tab 3 of 5").click();
		 
		 try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 boolean unfollowed;
		  try {
    	    driver.findElement(By.id("maria ossama\n0 Followers — 0 Following"));
    	    unfollowed = true;
			System.out.println("maria ossama\n0 Followers — 0 Following");
    	 } catch (NoSuchElementException e) {
    	    unfollowed = false;
			System.out.println("unFollow failed");
    	 }
		 assertEquals(unfollowed, true);
		 driver.close();
		 driver.quit();

	}
}
