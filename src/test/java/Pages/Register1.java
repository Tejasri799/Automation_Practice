package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Utilities;

public class Register1 {
	WebDriver dr;
	Utilities ut;			//Declaring the utilities class from main......
	public Register1(WebDriver dr)
	{
		this.dr = dr;
		ut = new Utilities(dr);      //initializing the utilities class.......
	}
	By Click = By.xpath("//a[@class='login']");			//xpath for the SignIn field to be clicked.....
		
	public void Enter()					//method for the located element to be clicked......
	{
		WebElement w = ut.Explicit_wait(Click,20);
		w.click();
	}
}
		

