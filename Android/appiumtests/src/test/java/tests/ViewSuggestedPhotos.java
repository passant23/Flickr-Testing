package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class ViewSuggestedPhotos extends BaseClass {
	@Test
	public void ViewSuggestedPhotos(){
		 
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    driver.findElementById("Tab 1 of 5").click();
		    
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    List<MobileElement> items = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View");
		   
		    assert items.isEmpty() != true : "Empty Container";
		    int countOfPhotos = 0;
		    for ( int i = 0; i < items.size() ; i++)
		    {
		    	if((items.get(i)).isDisplayed() == true)
		    	{
		    		countOfPhotos=countOfPhotos+1;
		    		
		    	}
		    }
		    
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    assert countOfPhotos !=0 : "Containers are displayed";
		    assert !(driver.findElementById("AliaaKhalifa Sakura Season in Nihon 12/23/2021").isDisplayed()): "Static data by backend is displayed instead of random suggestions";
		    
	}
}



