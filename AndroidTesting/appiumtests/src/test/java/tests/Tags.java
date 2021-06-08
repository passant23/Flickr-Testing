package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileElement;
	
public class Tags  extends BaseClass {
	@Test(priority=1)
	public void AddTag()
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
			
			String myTag = "Nice Tag";

			//Add Tag
			MobileElement addTagButton = (MobileElement) driver.findElementByXPath(l.addTagsButton);
			addTagButton.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MobileElement tagTextField = (MobileElement) driver.findElementByXPath(l.tagTextField);
			tagTextField.sendKeys(myTag);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//New Tags
			ArrayList<String> tags = new ArrayList<String>();
			for(MobileElement tag : (MobileElement) driver.findElementsByXPath(l.tagsList))
				tags.Add(tag.text);
			
			boolean foundIt = false;
			for(String Text : tags)
				if(Text.equals(myTag))
					foundIt = true;
				
			assert foundIt == true;

			driver.navigate().back();
	}
}