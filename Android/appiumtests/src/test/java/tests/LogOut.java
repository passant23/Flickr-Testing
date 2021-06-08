package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class LogOut extends BaseClassLogIn{

	@Test
	public void LogOut() {
		

		 
		    
		  MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
		    e1.click();
		    e1.sendKeys("pa@gmailgmail.com");
		   
		   
		   try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		    
		    driver.findElementById(l.nextId).click();
		    driver.findElementByXPath(l.passwordLoginXpath).setValue("pa@gmailgmail12!P");
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    driver.findElement(By.id(l.signInButtonId)).click();
		    
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    driver.findElement(By.id("Tab 3 of 5")).click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		    MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"p test\n0 Followers — 0 Following\"]/android.widget.Button");
		    el1.click();
		    
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

//		    driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[8]").click();
//		    AndroidElement list = (AndroidElement) driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View");
//		    el1.click();
//		    
//		    MobileElement listItem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollIntoView("+"new UiSelector().description(\"Switches\"));"));
//		    
//		    listItem.click();
		    
		    
		    
		    driver.findElementById("Sign Out").click();
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		    MobileElement getStarted = driver.findElement(ById.id("Get Started"));
		    
		    assert getStarted.isDisplayed();
		    
		    getStarted.click();
		    
		    MobileElement logInTitle = driver.findElement(ById.id(l.logInTitleAccessibilityId));
		    
		    assert logInTitle.isDisplayed();
		    
		    
		    
		    
}
}
