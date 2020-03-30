package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class Profile_Page {
	WebDriver dr;
	Utilities ut;
	public Profile_Page(WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	By profile = By.xpath("//a[@title='View my customer account']");		//xpath to locate the registered account name......
	By Logout = By.xpath("//a[@title='Log me out']");		//xpath to locate the signout button.......... 
	
	
	public String Verify()	//method for explicit wait condition and  to verify the registered account name as displayed above..........
	{
		
		WebElement we = ut.WaitForElement(profile, 10);
		we = ut.elementToBeClickable(profile, 10);
		return we.getText();
		
		//dr.findElement(Logout).click();				//method for locating and clicking the signout box in the application......
	}
}


