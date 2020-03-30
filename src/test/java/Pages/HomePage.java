package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class HomePage {
	WebDriver dr;
	Utilities ut;			//Declaring the utilities class from main......
	public HomePage(WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);      //initializing the utilities class.......
	}
	By signin = By.xpath("//a[@class='login']");			//xpath for the SignIn field to be clicked.....
		
	public void Enter()
	{
		WebElement we = ut.WaitForElement(signin, 10);
		we = ut.elementToBeClickable(signin, 10);
		we.click();
	}
}
		

