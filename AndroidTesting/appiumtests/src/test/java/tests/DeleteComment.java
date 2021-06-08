package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileElement;
	
public class DeleteComment  extends BaseClass {
	@Test(priority=1)
	public void DeleteAComment()
	{		 
			MobileElement intermediateTab = (MobileElement) driver.findElementByXPath(l.intermediateTab);
			intermediateTab.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MobileElement publics = (MobileElement) driver.findElementByXPath(l.publics);
			publics.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			//Click on photo (No Xpath, only manual)
			MobileElement photo = (MobileElement) driver.findElementByXPath(l.photo);
			publics.click();
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String myComment = "This is not Working!! V2";

			//Comment on photo
			MobileElement commentButton = (MobileElement) driver.findElementByXPath(l.commentButton);
			commentButton.sendKeys(myComment);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String firstComment = (MobileElement) driver.findElementsByXPath(l.comments)[0].text;
			
			//New Comments
			ArrayList<String> newComments = new ArrayList<String>();
			for(MobileElement Text : (MobileElement) driver.findElementsByXPath(l.comments))
				newComments.Add(Text.text);
			
			boolean foundIt = false;
			for(String Text : newComments)
				if(Text.equals(firstComment))
					foundIt = true;
				
			assert foundIt == false;

			driver.navigate().back();
	}
}