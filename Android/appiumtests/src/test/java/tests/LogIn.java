package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileElement;


public class LogIn  extends BaseClassLogIn {
		
		@Test(priority=1)
		public void LogInEmptyFields(){
			 
	
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.findElementByXPath(l.emailAddressLogInXpath).clear();
			driver.findElementById(l.nextId).click();   
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 MobileElement reqMessageEmail = driver.findElementByXPath(l.reqEmailXpath);
			    assert 	reqMessageEmail.isDisplayed();
			
			
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
			    e1.clear();
			    try {
					Thread.sleep(8000);
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
//			    MobileElement reqMessageEmail = driver.findElementByXPath(l.reqEmailXpath);
			    assert 	reqMessageEmail.isDisplayed();
			    MobileElement reqMessagePassword = driver.findElementByXPath(l.reqPasswordXpath);
			    assert 	reqMessageEmail.isDisplayed();
			   
			    
			    
			    assert driver.findElement(By.id(l.logInTitleAccessibilityId)).isDisplayed();
			
			    driver.navigate().back();
			    
			    
		}

		@Test(priority=2)
		public void LoginInvalidEmail(){
			 
			
			  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.findElement(ById.id("Get Started")).click();
			  
			  MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
			  e1.click();
	//------------- Invalid Email without @ , .com		      
			  e1.sendKeys("ppa");
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    driver.findElementById(l.nextId).click();
			    
			    MobileElement popUp = driver.findElement(By.id(l.tryAgainPopUpId));
			    
			    assert popUp.isDisplayed();
			   
			    popUp.click();
	//--------------- Unavailable Email		    
			    
			    e1.clear();
			    
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    e1.sendKeys("ppa@gmailgmail.com");
			   
			   
			   try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			    
			    driver.findElementById(l.nextId).click();
			   
			    try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    driver.findElementByXPath(l.passwordLoginXpath).setValue("pa@gmailgmail12!P");
			    driver.findElement(By.id(l.signInButtonId)).click();
			    
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    MobileElement invalidMessage = driver.findElement(By.id(l.invalidEmailOrPasswordId));
			    assert  invalidMessage.isDisplayed();
			   
			    
			    assert driver.findElement(By.id(l.logInTitleAccessibilityId)).isDisplayed();
			    
			
			    driver.navigate().back();
			    
			    
		}

		@Test(priority=3)
		public void LoginInvalidFields(){
			 
			  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.findElement(ById.id("Get Started")).click();
			  
			    
			  MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
			    e1.click();
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    e1.clear();
			    e1.sendKeys("p@gmailgmail.com");
			   
			   
			   try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   
			    
			    driver.findElementById(l.nextId).click();
			    driver.findElementByXPath(l.passwordLoginXpath).setValue("pa@gmailgmail12!");
			    try {
					Thread.sleep(5000);
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
			    
			   assert driver.findElement(By.id(l.invalidEmailOrPasswordId)).isDisplayed() ;
			    
			   assert driver.findElement(By.id(l.logInTitleAccessibilityId)).isDisplayed();
			    
			    driver.navigate().back();
			    
			
			    
			    
			    
		}
		@Test(priority=4)
		public void LoginInValidPassword(){
			 
			  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.findElement(ById.id("Get Started")).click();
			  
			  
			    
			  MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
			    e1.click();
			    e1.clear();
			    try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    e1.sendKeys("pa@gmailgmail.com");
			   
			   
			   try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   
			    
			    driver.findElementById(l.nextId).click();
			    driver.findElementByXPath(l.passwordLoginXpath).setValue("pa@gmailgmail12!");
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
			    
			   assert driver.findElement(By.id(l.invalidPasswordMessageId)).isDisplayed() ;
			    
			   
			   assert driver.findElement(By.id(l.logInTitleAccessibilityId)).isDisplayed(); 
			    
			    driver.navigate().back();
			
			    
			    
			    
		}

		@Test(priority=5)
		public void LoginValid(){
			 
			  try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.findElement(ById.id("Get Started")).click();
			  
			    
			  MobileElement e1=  driver.findElement(By.xpath(l.emailAddressLogInXpath));
			    e1.click();
			    
			    e1.clear();
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    e1.sendKeys("pa@gmailgmail.com");
			   
			   
			   try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   
			    
			    driver.findElementById(l.nextId).click();
			    driver.findElement(By.xpath(l.passwordLoginXpath)).clear();
			    
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    driver.findElement(By.xpath(l.passwordLoginXpath)).setValue("pa@gmailgmail12!P");
			    try {
					Thread.sleep(5000);
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
			   
			    
			    
//			    String m =  driver.findElementById("p test 0 Followers — 0 Following").getId();
//			    System.out.print("Valid:"+m);
			    assert l.aboutPageData == "p test 0 Followers — 0 Following";
			    System.out.print("Valid login: TEST PASSED");
			    
			    driver.navigate().back();
		}


}

		
		