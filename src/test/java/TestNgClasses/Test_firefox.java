package TestNgClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.Utilities;
import ExcelDataUtils.ReadExcel;
import Pages.AmountInTheCart;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Profile_Page;
import Pages.Register_Page;
import Pages.SignUp_Page;


public class Test_firefox
{
	WebDriver dr;
	ReadExcel data;
	Utilities ut;
	HomePage home;
	SignUp_Page signup;
	Register_Page reg;
	Profile_Page pro;
	LoginPage login;
	AmountInTheCart price;
	int counter = 1;
	
	@BeforeMethod
	public void browserlaunch() 
	{
		ut = new Utilities(dr);
		dr = ut.launchBrowser("Firefox","http://automationpractice.com/index.php");		//launching browser............
	}
	
  @Test(dataProvider = "InvalidData")
  public void InvalidLogin(String mail,String firstname, String lastname, String password, String address, String city, String zip, String phone_no, String my_address, String Exp_res)
  {  
	  home = new HomePage(dr);		//initializing the home page..........
	  home.Enter();			//calling the homepage page for execution...........
	  signup = new SignUp_Page(dr);		// initializing the signup page.........
	  signup.ToRegister(mail);		//calling the signup page for execution...........
	  reg = new Register_Page(dr);		//initializing the register page...............
	  reg.Registration(firstname, lastname, password, address, city, zip, phone_no, my_address);	//calling registration page.......
	  String err =reg.InvalidEmailError();		//reading error message...........
	  ut.ScreenShot(counter);			//to take a screenshot of this page.........
	  ut.Sleep(1000);
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(err, Exp_res);		//comparing actual and expected results...........
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider					//reading data from excel ............
  public String[][] InvalidData() {
	  data = new ReadExcel();
	  data.get_data("Invalid Registration",1,10);
	  return data.testdata;
  }
  
  @Test(dataProvider = "validData")
  public void validLogin(String mail,String firstname, String lastname, String password, String address, String city, String zip, String phone_no, String my_address,  String profile_name)
  {
	 
	  home = new HomePage(dr);		//initializing the home page..........
	  home.Enter();			//calling the homepage page for execution...........
	  signup = new SignUp_Page(dr);		// initializing the signup page.........
	  signup.ToRegister(mail);		//calling the signup page for execution...........
	  reg = new Register_Page(dr);		//initializing the register page...............
	 reg.Registration(firstname, lastname, password, address, city, zip, phone_no, my_address);		//calling registration page..............
	 pro = new Profile_Page(dr);		//initializing the profile page.........
	  String acc_name = pro.Verify();		//calling the verify method............ 
	  ut.ScreenShot(counter);		//taking a screenshot for profile name............
	  ut.Sleep(1000);
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(acc_name,profile_name);		//comparing actual profile name and expected profile name...........
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider				//reading data from excel............
  public String[][] validData() {
	  data = new ReadExcel();
	
	  //SINCE It's Registration, "Mail ID" has to be changed...
	//So, for this test case mail id should be changed in Excel............
	  
	  data.get_data("valid registration",2,10);	 
	  return data.testdata;
  }
  	@Test(dataProvider = "AddToCart")			//test to login and adding products and reading the total cart value............
  	public void AddToCart(String username, String password, String Exp_price) 
  	{  
  		
  		home = new HomePage(dr);
  		home.Enter();
	  login = new LoginPage(dr);		//initializing login page............
	  login.DoLogin(username, password);		//calling login page............
	  
	  price = new AmountInTheCart(dr);			//initializing the amount in the cart class............
	  String act_price = price.AmountInCart();		//reading the actual price of the cart......... 
	  
	  ut.ScreenShot(counter);			//taking the screenshot of the cart........
	  ut.Sleep(1000);
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(act_price,Exp_price);			//comparing the values......
	  sa.assertAll();
	  dr.quit();
  }
  @DataProvider				//reading data from excel...........
  public String[][] AddToCart() {
	  data = new ReadExcel();
	  data.get_data("Login Credentials",1,3);
	  return data.testdata;
  }
 
}
