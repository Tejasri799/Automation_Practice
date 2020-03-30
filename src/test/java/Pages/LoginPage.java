package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;


public class LoginPage {
	WebDriver dr;
	Utilities ut;
	int counter;
	public LoginPage(WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	By mail_id = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By submit = By.xpath("//button[@id='SubmitLogin']");
	
	public void EnterUserName(String username)
	{
	
		WebElement we = ut.WaitForElement(mail_id, 10);
		we = ut.elementToBeClickable(mail_id, 10);
		we.sendKeys(username);
	}
	
	public void EnterPassword(String pwd)
	{
		
		WebElement we = ut.WaitForElement(password, 10);
		we = ut.elementToBeClickable(password, 10);
		we.sendKeys(pwd);
	}
	
	public void ClickLoginBTn()
	{
		
		WebElement we = ut.WaitForElement(submit, 10);
		we = ut.elementToBeClickable(submit, 10);
		we.click();
	}
		
	public void DoLogin(String username, String password)
	{
		this.EnterUserName(username);
		this.EnterPassword(password);
		ut.ScreenShot(counter);
		ut.Update_log(" login checked for data "+username+" "+password);
		this.ClickLoginBTn();		
	}
}
