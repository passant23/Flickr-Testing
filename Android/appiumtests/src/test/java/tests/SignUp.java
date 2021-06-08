package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class SignUp extends BaseClassSignUp{
	
	@Test
	public void SignUpEmptyFields()
	{
		  driver.findElement(By.id(" Sign up here.")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	    MobileElement a1= driver.findElement(By.xpath(l.firstName));
		MobileElement a2= driver.findElement(By.xpath(l.lastName));
		String errorAge = l.ageErrorAccessibilityId;
		MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
		MobileElement a4= driver.findElement(By.xpath(l.age));   
		MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
		MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));

		a6.click();

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	assert driver.findElementByXPath(l.reqEmailXpath).isDisplayed();
	assert driver.findElementByXPath(l.reqPasswordXpath).isDisplayed();
	assert driver.findElementByXPath(l.requiredAgeSignUpXpath).isDisplayed();
	assert driver.findElementByXPath(l.requiredFirstNameXpath).isDisplayed();
	assert driver.findElementByXPath(l.requiredLastNameXpath).isDisplayed();
//	driver.findElementById(l.logInHereSignUpPageAccessibilityId).click();
//	driver.close();
//	driver.quit();
	driver.navigate().back();
            
	}
	@Test
	public void AgeInvalidInputSignUp()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 
	    MobileElement a1= driver.findElement(By.xpath(l.firstName));
		MobileElement a2= driver.findElement(By.xpath(l.lastName));
		MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
		MobileElement a4= driver.findElement(By.xpath(l.age));   
		MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
		MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));
//	    a1.setValue("passant");
//		a2.setValue("ahmed");
		
		///
		a1.clear();
		a2.clear();
		a3.clear();
		a4.clear();
		a5.clear();
		
		///
		
		
		a4.setValue("1aa");
		driver.getKeyboard();
//		a5.setValue("passant@hotmail.com");
		
//		a3.setValue("1234567891231");

		  
		          
		
		a6.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		MobileElement a7= driver.findElement(By.id("Please enter a valid no"));
		assert a7.isDisplayed() : "Please enter a valid no";
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.navigate().back();


//	driver.close();
//	driver.quit();
	}
	@Test
	public void AgeLessThan13SignUp()
	{
		 driver.findElement(By.id(" Sign up here.")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
    
    MobileElement a1= driver.findElement(By.xpath(l.firstName));
	MobileElement a2= driver.findElement(By.xpath(l.lastName));
	String errorAge = l.ageErrorAccessibilityId;
	MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
	MobileElement a4= driver.findElement(By.xpath(l.age));   
	MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
	MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));

	
	a4.setValue("12");

	
	
	a6.click();
	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	          
	
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	MobileElement a7= driver.findElement(By.id(l.ageErrorAccessibilityId));
	assert errorAge == l.ageErrorAccessibilityId : "Error message didnt appear for invalid age (less than 13)";
	
//	driver.findElementById(l.logInHereSignUpPageAccessibilityId).click();
	driver.navigate().back();
//	
//         
            
	}
	@Test

	public void SignUpEmail()
	{
		 driver.findElement(By.id(" Sign up here.")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	    
	    MobileElement a1= driver.findElement(By.xpath(l.firstName));
		MobileElement a2= driver.findElement(By.xpath(l.lastName));
		String errorAge = l.ageErrorAccessibilityId;
		MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
		MobileElement a4= driver.findElement(By.xpath(l.age));   
		MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
		MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));
		

	    a1.setValue("t");
		a2.setValue("p");
		a4.setValue("20");
		driver.getKeyboard();
		a5.setValue("t@test.com");
		a3.setValue("123456789aaA!");
		
	
		a6.click();
		
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		          
		
	
		assert driver.findElement(By.xpath(l.duplicatedEmailMessageXpath)).isDisplayed();
		
		assert driver.findElementById(l.signUpTitleAccessibilityId).isDisplayed();
		
		
		a5.clear();
		
		a5.setValue("t@test.com ");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
		a6.click();
		
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		          
		
		
		
		assert driver.findElementByAccessibilityId("Invalid input data. Invalid email address").isDisplayed();
		
		assert driver.findElementById(l.signUpTitleAccessibilityId).isDisplayed();
//		driver.findElementById(l.logInHereSignUpPageAccessibilityId).click();
//		driver.close();
//		driver.quit();
		driver.navigate().back();
	}
//	
	@Test

	public void SignUpPassword()
	{
		 driver.findElement(By.id(" Sign up here.")).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	   
	    
	    MobileElement a1= driver.findElement(By.xpath(l.firstName));
		MobileElement a2= driver.findElement(By.xpath(l.lastName));
		String errorAge = l.ageErrorAccessibilityId;
		MobileElement a3= driver.findElement(By.xpath(l.passwordSignUp));
		MobileElement a4= driver.findElement(By.xpath(l.age));   
		MobileElement a5= driver.findElement(By.xpath(l.emailAddressSignUp));
		MobileElement a6= driver.findElement(By.id(l.signUpButtonSignUpPageAccessibilityId));
		
		
		///
		a1.clear();
		a2.clear();
		a3.clear();
		a4.clear();
		a5.clear();
		
		///
		
	    a1.setValue("t");
		a2.setValue("p");
		a4.setValue("20");
		driver.getKeyboard();
		a5.setValue("t1@test.com");
		a3.setValue(" 123456789aa!");
		
	

		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		          
		
		a6.click();
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		          
		
		assert driver.findElement(By.id("Invalid Password")).isDisplayed();
		
		assert driver.findElementById(l.signUpTitleAccessibilityId).isDisplayed();
	    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
//		driver.findElementById(l.logInHereSignUpPageAccessibilityId).click();
		driver.navigate().back();
		
		
		
	}
	
}
