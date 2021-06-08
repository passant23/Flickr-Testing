package tests;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;


public class About extends BaseClass {
	
	@Test
	public void InvalidAboutWebsite(){
		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filedName="Website\nAdd Website...";
		driver.findElementById(filedName).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="12##$%!&&";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
//    	    driver.findElement(By.id(filedName));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
		 System.out.println("this URL: "+newPart+" is invalid, but it was accepted");
		 assert driver.findElement(By.id(filedName)).isDisplayed();
		 
		 
		 
		 driver.close();
		 driver.quit();
		 }

	@Test
	public void InvalidAboutTumblr(){
		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filedName="Tumblr\nAdd Tumblr...";
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId(filedName);
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="9228###42";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
//    	    driver.findElement(By.id(filedName));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
    	 assert driver.findElement(By.id(filedName)).isDisplayed();
    	
    	 
		 driver.close();
		 driver.quit();
		 
		 
	}

	@Test
	public void InvalidAboutInstagram(){
		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
//	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filedName="Instagram\nAdd Instagram...";
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId(filedName);
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="@@@@@@@@@@999";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
		 
    	 try {
    	    driver.findElement(By.id(filedName));
    	    present = true;
    	 } catch (NoSuchElementException e) {
    	    present = false;
    	 }
		 System.out.println("this URL: "+newPart+" is invalid, but it was accepted");
		 assert driver.findElement(By.id(filedName)).isDisplayed();
		 
		 driver.close();
		 driver.quit();
		 
		 
	}
	
	@Test
	public void InvalidAboutPinterest(){
//		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filedName="Pinterest\nAdd Pinterest...";
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId(filedName);
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="&&&&&&&1378%%";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
//		 
//    	 try {
//    	    driver.findElement(By.id(filedName));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
    	 assert driver.findElement(By.id(filedName)).isDisplayed();
		 
		 
    	 driver.close();
		 driver.quit();
	}	
	
	@Test
	public void InvalidAboutFacebook(){
		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filedName="Facebook\nAdd Facebook...";
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId(filedName);
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="&&9228###42";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
//		 
//    	 try {
//    	    driver.findElement(By.id(filedName));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
    	 assert driver.findElement(By.id(filedName)).isDisplayed();
		 
    	 driver.close();
		 driver.quit();
		 
	}

	@Test
	public void InvalidAboutTwitter(){
		
//		driver.findElementById("Get Started").click();
//		MobileElement el2=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
//		el2.sendKeys("mariamaximus1012@gmail.com");
//		driver.findElementById("Next").click();
//		MobileElement el4 =driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
//		el4.sendKeys("Mm$123456789");
//		driver.findElementById("Sign in").click();
//		driver.findElementById("Tab 3 of 5").click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String filedName="Twitter\nAdd Twitter...";
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId(filedName);
		el7.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		driver.findElementById("Edit").click();
		String newPart="6668##11111111";
		MobileElement el9 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		el9.sendKeys(newPart);
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
//    	    driver.findElement(By.id(filedName));
//    	    present = true;
//    	 } catch (NoSuchElementException e) {
//    	    present = false;
//    	 }
//		 System.out.println("this URL: "+newPart+" is invalid, but it was accepted");
		 assert driver.findElement(By.id(filedName)).isDisplayed();
//    	 assertEquals(present, true);
		 driver.close();
		 driver.quit();
		 
		 }
	
	
	
	
	
	
	
	
	
	
	
	
	
}