package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class Register2 {
	WebDriver dr;
	Utilities ut;
	public Register2(WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	By Email = By.xpath("//input[@id='email_create']");			//xpath to locate the email field.......
	By Create = By.xpath("//button[@id='SubmitCreate']");		//xpath to submit button which is to be clicked.........
		
	public void Mail(String r)		//method for explicit wait condition and  to enter the data into the located email field..........
	{
		WebElement w = ut.Explicit_wait(Email,100);
		w.sendKeys(r);
		
	}
	public void Enter()			//method for explicit wait condition and  to click the create email button..........
	{
		WebElement w = ut.Explicit_wait(Create,20);
		w.click();
	}
	public String ToRegister(String e)		//method for calling the above methods to occur systematically ..........
	{
		this.Mail(e);
		this.Enter();
		return null;
	}
}