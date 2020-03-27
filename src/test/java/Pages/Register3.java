package Pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.Utilities;

public class Register3 {		//class for registration step
	WebDriver dr;
	Utilities ut;
	public Register3(WebDriver dr)		//constructor class to initialize the webdriver element and main class function
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	//All are the respective xpaths for the mandatory fields which are to be selected and filled respectively as follows.....  
	
	By gender = By.xpath("//input[@id='id_gender1']");		//xpath for gender selection......		
	By firstname = By.xpath("//input[@id='customer_firstname']");	//xpath to locate the firstname field.....
	By lastname = By.xpath("//input[@id='customer_lastname']");		//xpath to locate the lastname field.....
	//By email = By.xpath("//input[@id='email']");		//since, automatically the given email is already displayed, then no need for filling again..........
	By password = By.xpath("//input[@id='passwd']");		//xpath to locate password field..........
	//By first_name = By.xpath("//input[@id='firstname']");		//the above firstname and lastname are automatically displayed here again.... 
	//By last_name = By.xpath("//input[@id='lastname']");		//to avoid overwriting....
	By address = By.xpath("//input[@id='address1']");		//xpath to locate address field........		
	By city = By.xpath("//input[@id='city']");			//xpath to locate city field......
	By state = By.xpath("//select[@id='id_state']");		//xpath to select state field......
	By state1 = By.xpath("//select[@id='id_state']/option[5]");		//another xpath to select the state dropdown field.......
	By zip_code = By.xpath("//input[@id='postcode']");		//xpath to find zip/postal code.....
	By country = By.xpath("//select[@id='id_country']/option[2]");			//xpath to seleect country......
	By phone = By.xpath("//input[@id='phone_mobile']");				//xpath to locate mobile phone field......		
	By alias_Address = By.xpath("//input[@value='My address']");		//xpath to locate my address........
	By submit = By.xpath("//button[@id='submitAccount']");			//xpath to locate the submit button...
	By error=By.xpath("//div[@class='alert alert-danger']/ol");		//xpath to locate an error message if any of the field is missed to fill....

	public String error_mes()		//method for explicit wait condition and  to read the error message..........
	{
	WebElement data = ut.Explicit_wait(error, 20);
	    return data.getText();
	}
	
	
	public void Gender()	//method for explicit wait condition and  to select the gender radio button..........
		{
		WebElement data = ut.Explicit_wait(gender, 100);
		data.click();
		}
		
	public void Firstname(String r)		//method for explicit wait condition and  to enter the data into the located firstname field..........
		{
		WebElement data = ut.Explicit_wait(firstname, 20);
		if(r.contains("blank"))			//condition to leave the field empty.......
		{
			r="";
			data.sendKeys(r);
			
		}
		else
		data.sendKeys(r);
		}
	
	public void Lastname(String r)		//method for explicit wait condition and  to enter the data into the located lastname field..........
		{
		WebElement data = ut.Explicit_wait(lastname, 20);
		if(r.contains("blank"))
		{
			r="";
			data.sendKeys(r);
			
		}
		else
		data.sendKeys(r);
		}
	
	
	
	public void Password (String r)		//method for explicit wait condition and  to enter the data into the located password field..........
	{
		WebElement data = ut.Explicit_wait(password, 20);
		if(r.contains("blank"))
		{
			r="";
			data.sendKeys(r);
			
		}
		else
		data.sendKeys(r);
	}
	

	public void Address(String r)		//method for explicit wait condition and  to enter the data into the located address1 field..........
	{
		WebElement data = ut.Explicit_wait(address, 20);
		if(r.contains("blank"))
		{
			r="";
			data.sendKeys(r);
			
		}
		else
		data.sendKeys(r);
	}
	
	public void City(String r)		//method for explicit wait condition and  to enter the data into the located CITY field..........
	{
		WebElement data = ut.Explicit_wait(city, 20);
		if(r.contains("blank"))
		{
			r="";
			data.sendKeys(r);
			
		}
		else
		data.sendKeys(r);
	}
	
	
	public void State()		//method for explicit wait condition and  to select the state in the state dropdown field..........
	{
		
          WebElement data1 = ut.Explicit_wait(state1, 20);
		data1.click();
	

	}
	
	public void zip(String r)		//method for explicit wait condition and  to enter the data into the located zip/postal code field..........
	{
		WebElement data = ut.Explicit_wait(zip_code, 20);
		String s=r.substring(1, (r.length()-1));		//to enter the data as provided for the datatype upto 5 numbers......
		data.sendKeys(s);
	}
	
	public void country()		//method for explicit wait condition and  to select the country in the country dropdown box..........
	{
		WebElement data = ut.Explicit_wait(country,20);
	data.click();
	}
	
	public void Phone(String r)			//method for explicit wait condition and  to enter the data into the located mobile phone field..........
	{
		WebElement data = ut.Explicit_wait(phone,20);
		String s=r.substring(1, (r.length()-1));
		data.sendKeys(s);
	}
	
	public void AddressPrime(String r)		//method for explicit wait condition and  to enter the data into the located myaddress field..........
	{
		WebElement data = ut.Explicit_wait(alias_Address, 20);
		data.sendKeys(r);
	}
	
	public void Submit()		//method for explicit wait condition and  to click on the submit button.........
	{
		WebElement data = ut.Explicit_wait(submit, 20);
		data.click();
	}
	
	public void Registration(String fname, String lname, String pwd, String ph, String a1, String ci, String zip, String a2)		//method for the above methods calling in a one by one executable way..........
	{
		this.Gender();
		this.Firstname(fname);
		this.Lastname(lname);
		this.Password(pwd);	
		this.Address(a1);
		this.City(ci);
		this.State();
		this.zip(zip);
		this.country();
		this.Phone(ph);
		this.AddressPrime(a2);
		this.Submit();
		
	}
}
	



