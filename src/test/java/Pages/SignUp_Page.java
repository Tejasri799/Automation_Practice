package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class SignUp_Page {
	WebDriver dr;
	Utilities ut;
	public SignUp_Page (WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	By email = By.xpath("//input[@id='email_create']");			//xpath to locate the email field.......
	By create = By.xpath("//button[@id='SubmitCreate']");		//xpath to submit button which is to be clicked.........
		
	public void Mail(String r)		//method for explicit wait condition and  to enter the data into the located email field..........
	
		{
			WebElement we = ut.WaitForElement(email, 10);
			we = ut.elementToBeClickable(email, 10);
			we.sendKeys(r);
		}
		
	
	public void Enter()			//method for explicit wait condition and  to click the create email button..........
	{
			WebElement we = ut.WaitForElement(create, 10);
			we = ut.elementToBeClickable(create, 10);
			we.click();
		}
	
	public String ToRegister(String mail)		//method for calling the above methods to occur systematically ..........
	{
		this.Mail(mail);
		this.Enter();
		return mail;
	}
}