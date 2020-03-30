package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BaseClass.Utilities;

public class Register_Page{		//class for registration step
	WebDriver dr;
	Utilities ut;
	public Register_Page(WebDriver dr)		//constructor class to initialize the webdriver element and main class function
	{
		this.dr = dr;
		ut = new Utilities(dr);
	}
	//All are the respective xpaths for the mandatory fields which are to be selected and filled respectively as follows.....  
	
		
	By firstname = By.xpath("//input[@id='customer_firstname']");	//xpath to locate the firstname field.....
	By lastname = By.xpath("//input[@id='customer_lastname']");		//xpath to locate the lastname field.....
	By password = By.xpath("//input[@id='passwd']");		//xpath to locate password field..........
	By address = By.xpath("//input[@id='address1']");		//xpath to locate address field........		
	By city = By.xpath("//input[@id='city']");			//xpath to locate city field......
	By state = By.xpath("//div[@class='selector']//*[@id=\"id_state\"]/option[16]");		//xpath to select state field......
	//By state1 = By.xpath("//select[@id='id_state']/option[5]");		//another xpath to select the state dropdown field.......
	By zip = By.xpath("//input[@id='postcode']");		//xpath to find zip/postal code.....
	By country = By.xpath("//select[@id='id_country']/option[2]");			//xpath to select country......
	By phone = By.xpath("//input[@id='phone_mobile']");				//xpath to locate mobile phone field......		
	By alias_Address = By.xpath("//input[@value='My address']");		//xpath to locate my address........
	By submit = By.xpath("//button[@id='submitAccount']");			//xpath to locate the submit button...
	By error=By.xpath("//div[@class='alert alert-danger']/ol");		//xpath to locate an error message if any of the field is missed to fill....

	
	public String InvalidEmailError()
	{
		
		WebElement we = ut.WaitForElement(error, 10);
		we = ut.elementToBeClickable(error, 10);
		return we.getText();
	}
	
	public void Firstname(String fname)
	{
		
		WebElement we = ut.WaitForElement(firstname, 10);
		we = ut.elementToBeClickable(firstname, 10);
		we.sendKeys(fname);
	}
	
	public void Lastname(String lname)
	{
		
		WebElement we = ut.WaitForElement(lastname, 10);
		we = ut.elementToBeClickable(lastname, 10);
		we.sendKeys(lname);
	}
	
	public void Password(String pwd)
	{
		
		WebElement we = ut.WaitForElement(password, 10);
		we = ut.elementToBeClickable(password, 10);
		we.sendKeys(pwd);
	}
	
	public void Address(String add)
	{
		
		WebElement we = ut.WaitForElement(address, 10);
		we = ut.elementToBeClickable(address, 10);
		we.sendKeys(add);
	}
	
	public void City(String c)
	{
		
		WebElement we = ut.WaitForElement(city, 10);
		we = ut.elementToBeClickable(city, 10);
		we.sendKeys(c);
	}
	
	public void State()
	{
		WebElement we = ut.WaitForElement(state, 10);
		we = ut.elementToBeClickable(state, 10);
		we.click();
	}
	
	public void Postal(String code)
	{
		
		WebElement we = ut.WaitForElement(zip, 10);
		we = ut.elementToBeClickable(zip, 10);
		we.sendKeys(code);
	}
	
	public void Country()
	{
		WebElement we = ut.WaitForElement(country, 10);
		we = ut.elementToBeClickable(country, 10);
		we.click();
	}
	
	public void Phone(String num)
	{
		
		WebElement we = ut.WaitForElement(phone, 10);
		we = ut.elementToBeClickable(phone, 10);
		we.sendKeys(num);
	}
	
	public void Address1(String my_add)
	{
		
		WebElement we = ut.WaitForElement(alias_Address, 10);
		we = ut.elementToBeClickable(alias_Address, 10);
		we.sendKeys(my_add);
	}

	public void Submit()
	{
		WebElement we = ut.WaitForElement(submit, 10);
		we = ut.elementToBeClickable(submit, 10);
		we.click();
	}
	
	public void Registration(String firstname, String lastname, String password, String address, String city, String zip, String phone_no, String my_address)		//method for the above methods calling in a one by one executable way..........
	{
		
		this.Firstname(firstname);
		this.Lastname(lastname);
		this.Password(password);	
		this.Address(address);
		this.City(city);
		this.State();
		this.Postal(zip);
		this.Country();
		this.Phone(phone_no);
		this.Address1(my_address);
		this.Submit();
		
	}
}
	



