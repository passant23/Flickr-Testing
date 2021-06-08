package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileElement;
	
public class Description  extends BaseClass {
	@Test(priority=1)
	public void AddDescription()
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
			
			String newDescription = "Very Unique Description";

			//Add Description
			MobileElement descriptionArea = (MobileElement) driver.findElementByXPath(l.editDescriptionArea);
			descriptionArea.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MobileElement descriptionTextField = (MobileElement) driver.findElementByXPath(l.editDescriptionTextField);
			descriptionTextField.sendKeys(newDescription);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//New Description
			MobileElement descriptionField = (MobileElement) driver.findElementByXPath(l.descriptionField);
				
			assert descriptionField.text.equals(newDescription);

			driver.navigate().back();
	}
}