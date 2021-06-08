package tests;
	import org.openqa.selenium.By;
	import org.openqa.selenium.By.ById;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import io.appium.java_client.MobileElement;
	
public class Favourite  extends BaseClass {
	@Test(priority=1)
	public void FavouritePhoto()
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
			
			//Check button color
			MobileElement favouriteButton = (MobileElement) driver.findElementByXPath(l.favouriteButton);
			
			String favColor = favouriteButton.get_attribute("Color");
			
			favouriteButton.click(); //fave or unfave
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(favColor.equals("Blue")) //Unfave
				assert !favouriteButton.get_attribute("Color").equals("Blue");
			else //fave
				assert favouriteButton.get_attribute("Color").equals("Blue");
		
			driver.navigate().back();
	}
}