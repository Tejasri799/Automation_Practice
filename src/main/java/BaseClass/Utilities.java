package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Utilities
	 {
		static WebDriver dr;
		static int counter = 1;
		Logger Log;
		
		public Utilities(WebDriver dr)
			{
			this.dr = dr;
			Log = Logger.getLogger("devpinoyLogger");
			}
			
		//function to update a log message
		public void Update_log(String Message)
		{
			
			Log.debug(Message);
		}
		
		//function for waiting for the element visiblity
		public WebElement WaitForElement(By locator, int time) {
			// TODO Auto-generated constructor stub
		   try {
			   
			WebDriverWait wait=new WebDriverWait(dr,time);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element;
		   }
		   catch(Exception e) {
			   System.out.println("Element not located" +e);
			  this.Update_log("Exception in WaitForElement method");
		   }
		return null;
		}	
		
		
		//function for waiting for element to be clickable
		public WebElement elementToBeClickable(By locator,int timeout) {
			try {
			WebDriverWait wait=new WebDriverWait(dr,timeout);
			WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
			return element;
			} catch(Exception e) {
				   System.out.println("Element not located" +e);
				   this.Update_log("Exception in elementToBeClickable method");
			   }
			return null;
			
		}

		//make a eclipse sleep for a while
		public void Sleep(int time)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		 // function to take a screenshot
			public void ScreenShot(int counter)
			{
				
				File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			    File f2=new File("src\\test\\resources\\screenshots\\"+counter+".png");
			try 
			{
				FileUtils.copyFile(f1, f2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
			}
		
		
		//Function to Launch the Browser
		public WebDriver launchBrowser(String BrowserType, String Url)
		{
			
			switch(BrowserType)
			{
			// to launch Chrome
			case"CHROME":
			{
				String DriverPath ="src\\test\\resources\\DRIVER\\chromedriver_v80.exe";
				System.setProperty("webdriver.chrome.driver", DriverPath);
				 dr = new ChromeDriver(); 										
				 dr.manage().window().maximize();								//maximize window
				 dr.get(Url);
				 dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait
				
				 this.Update_log("chrome browser Successfully Launched!!");
		
				 break;
			}
			
			// to launch FireFox
			case "Firefox":
			{
				String DriverPath ="src\\test\\resources\\Drivers\\geckodriver_v0.26.exe";
				System.setProperty("webdriver.gecko.driver", DriverPath);
				 dr = new FirefoxDriver(); 
				 dr.get(Url);
				 dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait
				 
				 this.Update_log("FiREfox  browser Successfully Launched!!");
				 
				 break;
			}
			}
			return dr;
			}
			
			
		}



	