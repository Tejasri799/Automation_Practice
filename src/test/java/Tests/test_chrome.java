package Tests;

import org.testng.annotations.Test;

import BaseClass.Utilities;
import Excel.ExcelData;
import Pages.Register1;
import Pages.Register2;
import Pages.Register3;
import Pages.Register4;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class test_chrome extends ExcelData {
	public static WebDriver dr;			
	Utilities ut;
	Register1 reg1;
	Register2 reg2;
	Register3 reg3;
	Register4 reg4;
	// declaring all the pom pages and main class page as above...........
	String act_result;
	int c1=0;			//initializing an integer count variable for sreenshots method.......... 
  @Test(dataProvider = "dp")		//initializing test method using dataprovider.............
  public void f(String email,String fname, String lname, String pwd, String ph, String a1, String ci, String zip, String a2,String exp_result) {
	  reg1=new Register1(dr);		//initializing the register1 page..........
	  reg1.Enter();			//calling the register1 pom page for execution...........
	  reg2=new Register2(dr);	// initializing the register2 page.........
	  reg2.ToRegister(email);		//calling the register2 pom page for execution...........
	  reg3=new Register3(dr);		//initializing the register3 page...............
	  reg3.Registration(fname,lname,pwd,ph,a1,ci,zip,a2);	//calling the register3 pom page for execution...........
	   try {
	   reg4=new Register4(dr);		//initializing the register4 page..........
	   act_result = reg4.Profile();		//calling the register4 pom page for execution...........
	 	 
	   }
	   catch(NullPointerException e)
	   {
		   act_result= reg3.error_mes();
		
	   }
	   ut.ScreenShot(c1);			//calling the screenshot method from utilities.............. 
	   System.out.println(act_result);		//printing the actual result(executed result)........
	   System.out.println(exp_result);		//printing the expected result.......
	   Assert.assertTrue(act_result.contains(exp_result));		//comparing both the above results..............

  }
  @BeforeMethod		//method for launching the chrome browser...............
  public void beforeMethod() {
	  ut = new Utilities(dr);
	  dr = ut.bb("Chrome");

  }

  @AfterMethod				//method for closing the application after the execution..........
  public void afterMethod() {
	  dr.close();
	  c1++;
  }


  @DataProvider			//method for reading the data from excel to enter into the respective fields in the application using dataprovider..........
  public String[][] dp() {
	  getExcel("Sheet1");
	  return data;   
  }
}